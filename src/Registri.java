import java.math.BigInteger;

public class Registri {
    private  long value;
    private String Ime;
    private Adresa adress;

    public Registri(long value,String Ime,Adresa adress){
        this.Ime = Ime;
        this.value = value;
        this.adress = adress;
    }
    public long getValue(){ return value;}
    public void setValue(long value){ this.value=value;}

    public static class Adresa{
        int value;
        String adresa;

        public Adresa(int value,String adresa){
            this.value = value;
            this.adresa = adresa;
        }
        public String getAd(){
            return this.adresa;
        }
        public int getVa(){
            return this.value;
        }
    }
public int getVal(){
        return this.adress.value;
}
public  void setVal(int value){this.adress.value=value;}


public String getAdr(){
        return this.adress.adresa;
}

    public  String value64bit(){
        if(value>=0){
            return String.format("%064d",new BigInteger(Long.toBinaryString(value)));
        }else {
            String SFbitvalue = Long.toBinaryString(value);
            return SFbitvalue.substring(SFbitvalue.length()-64, SFbitvalue.length());
        }
    }
    public String getIme(){return Ime;}
    public void setIme(String Ime)
    {this.Ime = Ime;}

    public String Adrese() {
        switch (this.Ime) {
            case "r0":
                this.adress.adresa = "0x000";
               return this.adress.adresa;
            case "r1":
                this.adress.adresa = "0x001";
                return this.adress.adresa;
            case "r2":
                this.adress.adresa = "0x002";
                return this.adress.adresa;
            case "r3":
                this.adress.adresa = "0x003";
                return this.adress.adresa;
            case "r4":
                this.adress.adresa = "0x004";
                return this.adress.adresa;
        }return this.adress.adresa;
        }
    }

