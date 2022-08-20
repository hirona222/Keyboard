import static java.awt.event.KeyEvent.*;

public class Score{
    private String mode;
    private long start_frame;
    private boolean is_start;
    private double sample_frq = 44100;
    private int frame_ms;
    private int play_note_before = -1;
    private double volume = 1.0;
    private Code[] score;

    public Score(){
        //音符の作成
        this.mode = "Triangle";
        double a_frq = 440.0;    //ラA4
        double r = 1.0594630943592953;

        Note note_null = new Note(1000,0,0,44100,mode);

        //コード:Codeの作成
        Code code_C = new Code(new Note[] {
                new Note("C4"),
                new Note(""),G3});
        Code code_Dm = new Code(new Note[] {D3,F3,A4});
        Code code_Em = new Code(new Note[] {E3,G3,B4});
        Code code_F = new Code(new Note[] {F3,A4,C4});
        Code code_G = new Code(new Note[] {G3,B4,D4});
        Code code_Am = new Code(new Note[] {A4,C4,E4});
        Code code_Bm5 = new Code(new Note[] {B4,D4,F4});


        Code code_Dm7 = new Code(new Note[] {C4,D4,E4});
        Code code_G7 = new Code(new Note[] {C4,D4,E4});
        Code code_Bm7 = new Code(new Note[] {C4,D4,E4});
        Code code_E7 = new Code(new Note[] {C4,D4,E4});

        Code code_null = new Code(new Note[] {note_null});
        Code code_A7 = new Code(new Note[] {F3,B3,D3});


        //楽譜:Scoreの作成
        this.score = new Code[]{code_C,code_Am,code_F,code_G,code_null,code_null};
        this.volume = 0.7;
        this.frame_ms = 1000;
        this.play_note_before = this.score.length - 1;

    }
    public double cul_score() {
        //score[] に基づいて再生
        int num_code = this.score.length;
        int ms = (int)Math.round(this.start_frame/(this.sample_frq/1000));
        int num_note = (int)Math.floor(ms/this.frame_ms);
        int play_note = num_note % num_code;
        //System.out.print("play_note ");
        //System.out.println(play_note);

        if(play_note != this.play_note_before) {
            this.score[this.play_note_before].set_off();
            this.score[play_note].set_on();
            this.play_note_before = play_note;
        }
        double value;
        value = this.score[play_note].value();
        this.start_frame++;
        return value*this.volume;
    }

    public double factorial(double num,int i){
        double hoge;
        hoge = 1;
        if(i<0){
            for (int j = 0; j < -1*i; j++) {
                hoge = hoge / num;
            }
        }else {
            for (int j = 0; j < i; j++) {
                hoge = hoge * num;
            }
        }
        return hoge;
    }
    public void start_code(){
        this.is_start = true;
        start_frame = 0;
    }
    public void set_volume(double volume){
        this.volume = volume;
    }

}
