import java.util.Timer;
import java.util.TimerTask;

public class Timer_task extends TimerTask {
    Keyboard keyboard;
    Piano piano;
    private int num = 0;
    private boolean endFlag = true;
    Timer timer;
    private long start_time;
    private long before_time;
    private String mode;
    public Timer_task(String mode){
        this.mode = mode;
    }

    public void run() {

        num++;

        if(num>1000 && endFlag == true){
            System.out.println("End");
            timer.cancel();
        }
        //System.out.print(keyboard.buffer_update());
        if(num % 1000 == 0){
            if(this.mode.equals("Keyboard")) {
                keyboard.repaint();
            }else if(this.mode.equals("Piano")){
                piano.repaint();
            }
        }
        send_elapsed_time_us();
        //send_elapsed_time();

    }
    public void send_elapsed_time(){
        long now_time = System.currentTimeMillis();
        long elapsed = now_time - this.before_time;
        System.out.print("elapsed [ms] ");
        System.out.println(elapsed);
        this.before_time = now_time;
    }

    public void send_elapsed_time_us(){
        long now_time = System.nanoTime();
        long elapsed = now_time - this.before_time;
        System.out.print("elapsed [us] ");
        System.out.println((int)(elapsed/1000));
        this.before_time = now_time;
    }

    public void setKeyboard(Keyboard keyboard){
        this.keyboard = keyboard;
    }
    public void setPiano(Piano piano){
        this.piano = piano;
    }
    public void setTimer(Timer time3){
        this.timer = time3;
    }
    public void setEndTimer(){
        this.endFlag = true;
    }
    public void clearEndTimer(){
        this.endFlag = false;
    }
}