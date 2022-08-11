import java.util.Arrays;

public class LPF {
    private double cut_frq;
    private double angle_cut_frq;
    private double[] before_out;
    private double[] before_value;
    private double Tc;
    private double T;

    private double[] num;
    private double[] den;
    private int mode;


    public LPF(double cut_frq){
        this.cut_frq = cut_frq;
        this.angle_cut_frq = this.cut_frq * 2 * Math.PI;
        this.before_out = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        this.before_value = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        this.T = 1/44100;
        this.Tc = 1/angle_cut_frq;

        //1次LPF Tastin
        double hoge = cut_frq*2*Math.PI/44100;
        this.num = new double[]{hoge,hoge};
        this.den = new double[]{hoge + 2 , hoge - 2 };
        this.mode = 2;

        /*
        //何もしない
        this.num = new double[]{1,0};
        this.den = new double[]{1,0};
        mode = 2;
         */
    }
    public String toString(){
        String text;
        text = "[" + Arrays.toString(this.num) + "] , [" + Arrays.toString(this.den) + "]";
        return text;
    }

    public void LPF_cul(double[] wave){
        //double[] wave_copy = new double[wave.length];
        //System.arraycopy(wave,0,wave_copy,0,wave.length);

        double[] wave_out = new double[wave.length];
        double hoge;
        for(int i = 0;i < wave.length;i++){
            hoge = 0;
            for(int j = 0;j < this.mode;j++){
                if(i-j <0){
                    hoge += num[j] * this.before_value[(i - j)*-1 - 1];
                }else {
                    hoge += num[j] * wave[i - j];
                }
            }
            for(int j = 1;j < this.mode;j++){
                if(i-j <0){
                    hoge -= den[j] * this.before_out[(i - j)*-1 - 1];
                }else {
                    hoge -= den[j] * wave_out[i - j];
                }
            }
            wave_out[i] = hoge/den[0];
        }

        for(int j = 0;j<this.mode;j++){
            this.before_out[j] = wave_out[wave.length-j-1];
            this.before_value[j] = wave[wave.length-j-1];
        }
        for(int i = 0;i < wave.length;i++){
            wave[i] = wave_out[i];
        }
/*
        hoge = wave_copy[0] + this.before_value;
        hoge = (wave[0] - (-1.807493 * this.before_value))/3.807493;
        wave[0] = (byte)(hoge);
        for(int i = 0;i < wave.length-1;i++){
            hoge = wave_copy[i+1] + wave_copy[i];
            hoge = (wave[i+1] - (-1.807493 * wave[i]))/3.807493;wave[i+1] =(byte)  ( hoge);//((this.Tc - this.T) * before_value + this.T * wave[i]) / this.Tc);
        }
        this.before_value = wave[wave.length-1];

 */
    }

}
