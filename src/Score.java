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
        Note C3 = new Note(1000,a_frq*factorial(r,-21),20,44100,mode);
        Note D3 = new Note(1000,a_frq*factorial(r,-19),20,44100,mode);
        Note E3 = new Note(1000,a_frq*factorial(r,-17),20,44100,mode);
        Note F3 = new Note(1000,a_frq*factorial(r,-16),20,44100,mode);
        Note G3 = new Note(1000,a_frq*factorial(r,-14),20,44100,mode);
        Note A3 = new Note(1000,a_frq*factorial(r,-12),20,44100,mode);
        Note B3 = new Note(1000,a_frq*factorial(r,-10),20,44100,mode);
        Note C4 = new Note(VK_A,a_frq*factorial(r,-9),20,44100,mode);
        Note D4 = new Note(VK_S,a_frq*factorial(r,-7),20,44100,mode);
        Note E4 = new Note(VK_D,a_frq*factorial(r,-5),20,44100,mode);
        Note F4 = new Note(VK_F,a_frq*factorial(r,-4),20,44100,mode);
        Note G4 = new Note(VK_J,a_frq*factorial(r,-2),20,44100,mode);
        Note A4 = new Note(VK_K,a_frq*factorial(r,0),20,44100,mode);
        Note B4 = new Note(VK_L,a_frq*factorial(r,2),20,44100,mode);
        Note C5 = new Note(59,a_frq*factorial(r,3),20,44100,mode);

        Note note_null = new Note(1000,0,0,44100,mode);

        //コード:Codeの作成
        Code code_C = new Code(new Note[] {C3,E3,G3});
        Code code_Dm = new Code(new Note[] {D3,F3,C4});
        Code code_Em = new Code(new Note[] {E3,G3,B3});
        Code code_F = new Code(new Note[] {A3,F3,C3});
        Code code_G = new Code(new Note[] {G3,B3,D3});
        Code code_Am = new Code(new Note[] {A3,E3,C3});
        Code code_Bm5 = new Code(new Note[] {F3,B3,D3});


        Code code_Dm7 = new Code(new Note[] {C4,D4,E4});
        Code code_G7 = new Code(new Note[] {C4,D4,E4});
        Code code_Bm7 = new Code(new Note[] {C4,D4,E4});
        Code code_E7 = new Code(new Note[] {C4,D4,E4});
        Code code_null = new Code(new Note[] {note_null});
        Code code_A7 = new Code(new Note[] {F3,B3,D3});


        //楽譜:Scoreの作成
        this.score = new Code[]{code_C,code_Am,code_Dm,code_G,code_null,
                code_C,code_A7,code_Dm,code_G,code_null};
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
