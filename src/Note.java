public class Note {
    private int key;
    private int volume = 1;
    private int times = 0;
    private double frq = 1;
    private double angle_frq = 1;
    private double angle_frq_discrete = 1;
    private double sample_frq = 1;
    private boolean on_flag = false;
    private String mode;

    public Note(int key,double frq,int volume,double sample_frq,String mode){
        this.key = key;
        this.frq =frq;
        this.volume = volume;
        this.sample_frq = sample_frq;

        this.angle_frq = this.frq * 2 * Math.PI;
        this.angle_frq_discrete = this.angle_frq/this.sample_frq;
        this.mode = mode;
    }
    public Note(String name){
        this.key = 1000;
        this.volume = 20;
        this.sample_frq = 44100;

        double a_frq = 440.0;    //ラA4
        double r = 1.0594630943592953;

        switch (name){
            //------------3---------------
            case "C3":
                this.frq = a_frq*factorial(r,-21);
                break;
            case "D3b":
                this.frq = a_frq*factorial(r,-20);
                break;
            case "D3":
                this.frq = a_frq*factorial(r,-19);
                break;
            case "E3b":
                this.frq = a_frq*factorial(r,-18);
                break;
            case "E3":
                this.frq = a_frq*factorial(r,-17);
                break;
            case "F3":
                this.frq = a_frq*factorial(r,-16);
                break;
            case "G3b":
                this.frq = a_frq*factorial(r,-15);
                break;
            case "G3":
                this.frq = a_frq*factorial(r,-14);
                break;
            case "A3b":
                this.frq = a_frq*factorial(r,-13);
                break;
            case "A3":
                this.frq = a_frq*factorial(r,-12);
                break;
            case "B3b":
                this.frq = a_frq*factorial(r,-11);
                break;
            case "B3":
                this.frq = a_frq*factorial(r,-10);
                break;

                //----------4------------------
            case "C4":
                this.frq = a_frq*factorial(r,-9);
                break;
            case "D4b":
                this.frq = a_frq*factorial(r,-8);
                break;
            case "D4":
                this.frq = a_frq*factorial(r,-7);
                break;
            case "E4b":
                this.frq = a_frq*factorial(r,-6);
                break;
            case "E4":
                this.frq = a_frq*factorial(r,-5);
                break;
            case "F4":
                this.frq = a_frq*factorial(r,-4);
                break;
            case "G4b":
                this.frq = a_frq*factorial(r,-3);
                break;
            case "G4":
                this.frq = a_frq*factorial(r,-2);
                break;
            case "A4b":
                this.frq = a_frq*factorial(r,-1);
                break;
            case "A4":
                this.frq = a_frq*factorial(r,0);
                break;
            case "B4b":
                this.frq = a_frq*factorial(r,1);
                break;
            case "B4":
                this.frq = a_frq*factorial(r,2);
                break;

                //----------------5-------------
            case "C5":
                this.frq = a_frq*factorial(r,3);
                break;
            case "D5b":
                this.frq = a_frq*factorial(r,4);
                break;
            case "D5":
                this.frq = a_frq*factorial(r,5);
                break;
            case "E5b":
                this.frq = a_frq*factorial(r,6);
                break;
            case "E5":
                this.frq = a_frq*factorial(r,7);
                break;
            case "F5":
                this.frq = a_frq*factorial(r,8);
                break;
            case "G5b":
                this.frq = a_frq*factorial(r,9);
                break;
            case "G5":
                this.frq = a_frq*factorial(r,10);
                break;
            case "A5b":
                this.frq = a_frq*factorial(r,11);
                break;
            case "A5":
                this.frq = a_frq*factorial(r,12);
                break;
            case "B5b":
                this.frq = a_frq*factorial(r,13);
                break;
            case "B5":
                this.frq = a_frq*factorial(r,14);
                break;


                //-----------------6---------------------
            case "C6":
                this.frq = a_frq*factorial(r,15);
                break;
            case "D6b":
                this.frq = a_frq*factorial(r,16);
                break;
            case "D6":
                this.frq = a_frq*factorial(r,17);
                break;
            case "E6b":
                this.frq = a_frq*factorial(r,18);
                break;
            case "E6":
                this.frq = a_frq*factorial(r,19);
                break;
            case "F6":
                this.frq = a_frq*factorial(r,20);
                break;
            case "G6b":
                this.frq = a_frq*factorial(r,21);
                break;
            case "G6":
                this.frq = a_frq*factorial(r,22);
                break;
            case "A6b":
                this.frq = a_frq*factorial(r,23);
                break;
            case "A6":
                this.frq = a_frq*factorial(r,24);
                break;
            case "B6b":
                this.frq = a_frq*factorial(r,25);
                break;
            case "B6":
                this.frq = a_frq*factorial(r,26);
                break;

                //-----------------------7-------------------
            case "C7":
                this.frq = a_frq*factorial(r,27);
                break;
            case "D7b":
                this.frq = a_frq*factorial(r,28);
                break;
            case "D7":
                this.frq = a_frq*factorial(r,29);
                break;
            case "E7b":
                this.frq = a_frq*factorial(r,30);
                break;
            case "E7":
                this.frq = a_frq*factorial(r,31);
                break;
            case "F7":
                this.frq = a_frq*factorial(r,32);
                break;
            case "G7b":
                this.frq = a_frq*factorial(r,33);
                break;
            case "G7":
                this.frq = a_frq*factorial(r,34);
                break;
            case "A7b":
                this.frq = a_frq*factorial(r,35);
                break;
            case "A7":
                this.frq = a_frq*factorial(r,36);
                break;
            case "B7b":
                this.frq = a_frq*factorial(r,37);
                break;
            case "B7":
                this.frq = a_frq*factorial(r,38);
                break;
            case "C8":
                this.frq = a_frq*factorial(r,39);
                break;

            default:
                this.frq = 10;
        }
        this.angle_frq = this.frq * 2 * Math.PI;
        this.angle_frq_discrete = this.angle_frq/this.sample_frq;
        this.mode = "Triangle";
    }

    private void disp_frq(){
        System.out.print(String.format("%.1f",this.frq));
        System.out.print(" ");
        System.out.println(this.key);
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
    public double value(){
        //音量を位相に合わせて変更：ADSR設定
        this.cul_volume();

        //現在の位相の値における値の取得
        double value;
        switch (mode){
            case "Sin":
                value = this.volume * Math.sin(this.angle_frq_discrete * this.times);
                break;
            case "Square":
                double p = this.angle_frq_discrete * this.times / 2 / Math.PI;
                p = p - Math.floor(p);
                if(p<0.5){
                    value = this.volume * 1;
                }else{
                    value = this.volume * -1;
                }
                break;
            case "Saw":
                p = this.angle_frq_discrete * this.times / 2 / Math.PI;
                p = p - Math.floor(p);
                value = this.volume * (-2*p + 1);
                break;
            case "Triangle":
                p = this.angle_frq_discrete * this.times / 2 / Math.PI;
                p = p - Math.floor(p);
                if(p<0.25){
                    value = this.volume * (4*p);
                } else if (p<0.75) {
                    value = this.volume * (-4*p + 2);
                } else {
                    value = this.volume * (4*p - 4);
                }
                break;
            case "Pulse_20":
                p = this.angle_frq_discrete * this.times / 2 / Math.PI;
                p = p - Math.floor(p);
                if(p<0.2){
                    value = this.volume * 1;
                }else{
                    value = this.volume * -1;
                }
                break;
            case "Pulse_10":
                p = this.angle_frq_discrete * this.times / 2 / Math.PI;
                p = p - Math.floor(p);
                if(p<0.1){
                    value = this.volume * 1;
                }else{
                    value = this.volume * -1;
                }
                break;
            case "Pulse_5":
                p = this.angle_frq_discrete * this.times / 2 / Math.PI;
                p = p - Math.floor(p);
                if(p<0.05){
                    value = this.volume * 1;
                }else{
                    value = this.volume * -1;
                }
                break;

            default:
                value = this.volume * Math.sin(this.angle_frq_discrete * this.times);
        }
        if(this.on_flag == true) {
            return value;
        }else{
            return 0;
        }
    }
    public void cul_volume(){

    }
    public void set_volume(int volume){
        this.volume = volume;
    }
    public void clear_phase(){
        this.times = 0;
    }
    public void inc_phase(){
        this.times = this.times + 1;
    }
    public void back_phase(int back_num){
        this.times = this.times - back_num;
    }
    public void set_on(){
        if(this.on_flag = false){
            this.clear_phase();
        }
        this.on_flag = true;
        this.disp_frq();
    }
    public void set_off(){
        this.on_flag = false;
    }
    public boolean get_state(){
        return this.on_flag;
    }
    public double get_frq(){
        return this.frq;
    }
    public int get_volume(){
        return this.volume;
    }
    public int get_key(){
        return this.key;
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        int result = volume;
        result = result * times + this.key*31;
        return result;
    }
}
