public class Instrukcije {

    private Registri registri;
    private String operand2;
    private long value;
    private String operacija;

    public Instrukcije(String operacija, Registri registri, String operand2){
        this.operacija=operacija;
        this.registri=registri;
        this.operand2=operand2;
        this.value= registri.getValue();
    }

}
