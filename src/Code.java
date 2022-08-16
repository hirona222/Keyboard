public class Code{
    public Note[] code_list;
    private double volume = 1.0;

    public Code(Note[] code_list){
        this.code_list = code_list;

    }
    public void set_on(){
        for(Note i:code_list){
            i.set_on();
        }
    }
    public void set_off(){
        for(Note i:code_list){
            i.set_off();
        }
    }
    public void set_volume(double volume){
        this.volume = volume;
    }
    public double value(){
        double value = 0;
        for(Note i:this.code_list){
            value += i.value();
            i.inc_phase();
        }
        return value*this.volume;
    }


}
