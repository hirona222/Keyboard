public class Code{
    public Note[] code_list;
    private double volume = 1.0;

    public Code(Note[] code_list){
        this.code_list = code_list;
    }
    public Code(String code){
        switch (code) {

            //長調　4
            case "C4":
                this.code_list = new Note[]{
                        new Note("C4"),
                        new Note("E4"),
                        new Note("G4")
                };
                break;
            case "Dm4":
                this.code_list = new Note[]{
                        new Note("D4"),
                        new Note("F4"),
                        new Note("A4")
                };
                break;
            case "Em4":
                this.code_list = new Note[]{
                        new Note("E4"),
                        new Note("G4"),
                        new Note("B4")
                };
                break;
            case "F4":
                this.code_list = new Note[]{
                        new Note("F4"),
                        new Note("A4"),
                        new Note("C5")
                };
                break;
            case "G4":
                this.code_list = new Note[]{
                        new Note("G4"),
                        new Note("B4"),
                        new Note("D5")
                };
                break;
            case "Am4":
                this.code_list = new Note[]{
                        new Note("A4"),
                        new Note("C5"),
                        new Note("E5")
                };
                break;
            case "Bm4":
                this.code_list = new Note[]{
                        new Note("B4"),
                        new Note("D5"),
                        new Note("F5")
                };
                break;

            //長調　3
            case "C3":
                this.code_list = new Note[]{
                        new Note("C3"),
                        new Note("E3"),
                        new Note("G3")
                };
                break;
            case "Dm3":
                this.code_list = new Note[]{
                        new Note("D3"),
                        new Note("F3"),
                        new Note("A3")
                };
                break;
            case "Em3":
                this.code_list = new Note[]{
                        new Note("E3"),
                        new Note("G3"),
                        new Note("B3")
                };
                break;
            case "F3":
                this.code_list = new Note[]{
                        new Note("F3"),
                        new Note("A3"),
                        new Note("C4")
                };
                break;
            case "G3":
                this.code_list = new Note[]{
                        new Note("G3"),
                        new Note("B3"),
                        new Note("D4")
                };
                break;
            case "Am3":
                this.code_list = new Note[]{
                        new Note("A3"),
                        new Note("C4"),
                        new Note("E4")
                };
                break;
            case "Bm3":
                this.code_list = new Note[]{
                        new Note("B3"),
                        new Note("D4"),
                        new Note("F4")
                };
                break;

            //長調5
            case "C5":
                this.code_list = new Note[]{
                        new Note("C5"),
                        new Note("E5"),
                        new Note("G5")
                };
                break;
            case "Dm5":
                this.code_list = new Note[]{
                        new Note("D5"),
                        new Note("F5"),
                        new Note("A5")
                };
                break;
            case "Em5":
                this.code_list = new Note[]{
                        new Note("E5"),
                        new Note("G5"),
                        new Note("B5")
                };
                break;
            case "F5":
                this.code_list = new Note[]{
                        new Note("F5"),
                        new Note("A5"),
                        new Note("C6")
                };
                break;
            case "G5":
                this.code_list = new Note[]{
                        new Note("G5"),
                        new Note("B5"),
                        new Note("D6")
                };
                break;
            case "Am5":
                this.code_list = new Note[]{
                        new Note("A5"),
                        new Note("C6"),
                        new Note("E6")
                };
                break;
            case "Bm5":
                this.code_list = new Note[]{
                        new Note("B5"),
                        new Note("D6"),
                        new Note("F6")
                };
                break;

            //長調4_根音1オクターブ下ーヘ音記号ドC3周辺
            case "C4_C3":
                this.code_list = new Note[]{
                        new Note("C3"),
                        new Note("E4"),
                        new Note("G4")
                };
                break;
            case "Dm4_D3":
                this.code_list = new Note[]{
                        new Note("D3"),
                        new Note("F4"),
                        new Note("A4")
                };
                break;
            case "Em4_E3":
                this.code_list = new Note[]{
                        new Note("E3"),
                        new Note("G4"),
                        new Note("B4")
                };
                break;
            case "F4_F3":
                this.code_list = new Note[]{
                        new Note("F3"),
                        new Note("A4"),
                        new Note("C5")
                };
                break;
            case "G4_G3":
                this.code_list = new Note[]{
                        new Note("G3"),
                        new Note("B4"),
                        new Note("D5")
                };
                break;
            case "Am4_A3":
                this.code_list = new Note[]{
                        new Note("A3"),
                        new Note("C5"),
                        new Note("E5")
                };
                break;
            case "Bm4_B3":
                this.code_list = new Note[]{
                        new Note("B3"),
                        new Note("D5"),
                        new Note("F5")
                };
                break;

            //長調4_根音1オクターブ下ーヘ音記号ドC2周辺
            case "C4_C2":
                this.code_list = new Note[]{
                        new Note("C2"),
                        new Note("E4"),
                        new Note("G4")
                };
                break;
            case "Dm4_D2":
                this.code_list = new Note[]{
                        new Note("D2"),
                        new Note("F4"),
                        new Note("A4")
                };
                break;
            case "Em4_E2":
                this.code_list = new Note[]{
                        new Note("E2"),
                        new Note("G4"),
                        new Note("B4")
                };
                break;
            case "F4_F2":
                this.code_list = new Note[]{
                        new Note("F2"),
                        new Note("A4"),
                        new Note("C5")
                };
                break;
            case "G4_G2":
                this.code_list = new Note[]{
                        new Note("G2"),
                        new Note("B4"),
                        new Note("D5")
                };
                break;
            case "Am4_A2":
                this.code_list = new Note[]{
                        new Note("A2"),
                        new Note("C5"),
                        new Note("E5")
                };
                break;
            case "Bm4_B2":
                this.code_list = new Note[]{
                        new Note("B2"),
                        new Note("D5"),
                        new Note("F5")
                };
                break;

            //長調4_転回　　エクセルで音符の組み合わせを記述して読み出そう
            case "C4onE4":
                this.code_list = new Note[]{
                        new Note("C5"),
                        new Note("E4"),
                        new Note("G4")
                };
                break;
            case "C4onG4":
                this.code_list = new Note[]{
                        new Note("C5"),
                        new Note("E5"),
                        new Note("G4")
                };
                break;

            case "Dm4onF4":
                this.code_list = new Note[]{
                        new Note("D5"),
                        new Note("F4"),
                        new Note("A4")
                };
                break;
            case "Dm4onA4":
                this.code_list = new Note[]{
                        new Note("D5"),
                        new Note("F5"),
                        new Note("A4")
                };
                break;
            case "Em4onG4":
                this.code_list = new Note[]{
                        new Note("E5"),
                        new Note("G4"),
                        new Note("B4")
                };
                break;
            case "Em4onB4":
                this.code_list = new Note[]{
                        new Note("E5"),
                        new Note("G5"),
                        new Note("B4")
                };
                break;
            case "F4onA4":
                this.code_list = new Note[]{
                        new Note("F5"),
                        new Note("A4"),
                        new Note("C5")
                };
                break;
            case "F4onC5":
                this.code_list = new Note[]{
                        new Note("F5"),
                        new Note("A5"),
                        new Note("C5")
                };
                break;
            case "G4onB4":
                this.code_list = new Note[]{
                        new Note("G5"),
                        new Note("B4"),
                        new Note("D5")
                };
                break;
            case "G4onD5":
                this.code_list = new Note[]{
                        new Note("G5"),
                        new Note("B5"),
                        new Note("D5")
                };
                break;
            case "Am4onC5":
                this.code_list = new Note[]{
                        new Note("A5"),
                        new Note("C5"),
                        new Note("E5")
                };
                break;
            case "Am4onE5":
                this.code_list = new Note[]{
                        new Note("A5"),
                        new Note("C6"),
                        new Note("E5")
                };
                break;
            case "Bm4onD5":
                this.code_list = new Note[]{
                        new Note("B5"),
                        new Note("D5"),
                        new Note("F5")
                };
                break;
            case "Bm4onF5":
                this.code_list = new Note[]{
                        new Note("B5"),
                        new Note("D6"),
                        new Note("F5")
                };
                break;



            default:
                this.code_list = new Note[]{
                        new Note("null")
                };
                break;
        }
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
