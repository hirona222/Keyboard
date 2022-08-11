import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

import static java.awt.event.KeyEvent.*;

public class Score extends JFrame implements LineListener ,KeyListener {

    private final int height = 600;
    private final int width = 600;
    private final int buffer_size = 4000;
    private final int frame_size = 500;  //500 = 11msの最大遅延

    private SourceDataLine source;
    private LPF lpf1;

    List<Note> list_note = new LinkedList<Note>();
    List<Note> list_score = new LinkedList<Note>();

    private byte[] wave = new byte[buffer_size];
    private byte[] wave_frame = new byte[frame_size];
    private String mode;

    public static void main(String[] args){
        System.out.println("Start main");
        Score score = new Score();

        java.util.Timer timer = new Timer();
        Timer_task timer_task = new Timer_task("Score");
        timer_task.setScore(score);
        timer_task.setTimer(timer);
        timer_task.clearEndTimer();
        timer.scheduleAtFixedRate(timer_task ,0,20);

        int count = 0;
        while(true){
            if(score.buffer_update()){
                System.out.print(count);
                System.out.println(" update");
                count = 0;
            }else{
                count++;
            }
        }

    }

    public Score(){
        //フレーム作成
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(this.width, this.height);
        setVisible(true);
        addKeyListener(this);

        //音符の作成
        this.mode = "Pulse_20";
        Note C4 = new Note(VK_A,269.292,20,44100,mode);
        Note D4 = new Note(VK_S,302.270,20,44100,mode);
        Note E4 = new Note(VK_D,339.286,20,44100,mode);
        Note F4 = new Note(VK_F,359.461,20,44100,mode);
        Note G4 = new Note(VK_J,403.482,20,44100,mode);
        Note A4 = new Note(VK_K,452.893,20,44100,mode);
        Note B4 = new Note(VK_L,508.355,20,44100,mode);
        Note C5 = new Note(59,538.584,20,44100,mode);

        list_note.add(C4);
        list_note.add(D4);
        list_note.add(E4);
        list_note.add(F4);
        list_note.add(G4);
        list_note.add(A4);
        list_note.add(B4);
        list_note.add(C5);

        this.lpf1 = new LPF(10000);
        System.out.println(this.lpf1.toString());

        //音声出力設定
        AudioFormat frmt= new AudioFormat(44100,8,1,true,false);
        DataLine.Info info= new DataLine.Info(SourceDataLine.class,frmt);
        try {
            this.source = (SourceDataLine) AudioSystem.getLine(info);
        } catch (LineUnavailableException e) {
            System.out.println("cant get line///");
            throw new RuntimeException(e);
        }
        this.source.addLineListener(this);
        this.source.flush();
        try {
            this.source.open(frmt,buffer_size);
        } catch (LineUnavailableException e) {
            System.out.println("cant open line....");
            throw new RuntimeException(e);
        }
        this.source.start();


    }

    public void send_state(){
        System.out.print("active ");
        System.out.print(this.source.isActive());
        System.out.print(" , running ");
        System.out.println(this.source.isRunning());
    }
    public void send_available(){
        System.out.print("available ");
        System.out.println(this.source.available());
    }
    public void send_remain(){
        System.out.print("remain size ");
        System.out.println(this.buffer_size - this.source.available());
    }
    public void send_buffer_size(){
        System.out.print("buffer size ");
        System.out.println(this.source.getBufferSize());
    }
    public void calculate_buffer(byte[] wave,int length){
        //バッファーの計算
        double[] wave_double = new double[length];
        //Noteインスタンスに基づいて計算
        for(int i = 0;i < length;i++) {
            double value = 0;
            for (Note j : this.list_score) {
                if (j.get_state()) {
                    value += j.value();
                    j.inc_phase();
                }
            }
            wave_double[i] = value;
        }

        //LPFを適用
        lpf1.LPF_cul(wave_double);

        //byteに変換
        for(int i = 0;i < length;i++) {
            long value_long;
            value_long = Math.round(wave_double[i]);
            if (value_long > 127){
                wave[i] = 127;
            }else if(value_long <-128 ){
                wave[i] = -128;
            }else{
                wave[i] = (byte)Math.round(value_long);
            }
        }
    }
    public boolean buffer_update(){
        //タイマーが呼び出す
        //buffer内が特定の数値以下になった場合内容を追加する。
        //44100Hzの場合,1msは44.1Frameとなる
        //this.send_available();
        //this.send_remain();
        long before_time = System.nanoTime();

        int now_available = this.source.available();
        if( this.buffer_size - now_available < this.frame_size){
            //bufferに残った量　＜　フレームサイズ
            this.calculate_buffer(this.wave_frame,this.wave_frame.length);
            this.source.write(this.wave_frame,0,this.wave_frame.length);

            long now_time = System.nanoTime();
            long elapsed = now_time - before_time;
            //System.out.print("elapsed [us] ");
            //System.out.println((int)(elapsed/1000));
            return true;
        }
        return false;

        //System.out.println("update buffer");
        //this.send_state();
    }
    @Override
    public void paint(Graphics g){
        Image imgBuf = createImage(this.width,this.height);
        Graphics gBuf = imgBuf.getGraphics();               //gBufがバッファの画像
        gBuf.setColor(Color.white);
        gBuf.fillRect(0,0,this.width,this.height);

        //各種　描画開始
        //System.out.println(this.source.getBufferSize());
        //System.out.println(this.source.available());
        //send_state();


        //描画完了
        Graphics graphics = getContentPane().getGraphics();
        graphics.drawImage(imgBuf,0,0,this);

    }
    @Override
    public void update(LineEvent event){
        //source_data_lineの open,close,start,stopイベント処理
        LineEvent.Type type = event.getType();
        if(type == LineEvent.Type.STOP){
            System.out.println("STOP source");
            this.buffer_update();
            //this.calculate_buffer(this.wave,this.wave.length);
            //this.source.write(this.wave,0,this.wave.length);
            System.out.println(this.source.isActive());

        }else if(type == LineEvent.Type.OPEN){
            System.out.println("OPEN source");
            //this.buffer_update();
            //this.calculate_buffer(this.wave,this.wave.length);
            //this.source.write(this.wave,0,this.wave.length);
        }else if(type == LineEvent.Type.START){
            System.out.println("START source");
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key_code = e.getKeyCode();
        //System.out.println(key_code);
        int list_size = list_note.size();
        for(int i = 0;i < list_size; i++){
            if(list_note.get(i).get_key() == key_code){
                list_score.add(new Note(list_note.get(i).get_key(),list_note.get(i).get_frq(),list_note.get(i).get_volume(),44100,this.mode));
                list_score.get(list_score.size() - 1).set_on();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key_code = e.getKeyCode();

        for(Note i:list_note){
            if(i.get_key() == key_code){
                i.set_off();
            }
        }
    }


}
