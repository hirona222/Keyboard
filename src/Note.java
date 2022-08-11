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

    public double value(){
        //音量を位相に合わせて変更：ADSR設定
        this.culcu_volume();

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
        return value;
    }
    public void culcu_volume(){

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
