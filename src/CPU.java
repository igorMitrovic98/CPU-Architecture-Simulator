import java.awt.*;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class CPU{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String instrukcija = "";
        String operacija = "";
        String operand1 = "";
        String operand2 = "";
        Registri[] registri = new Registri[5];
        Registri.Adresa addresa;
        String enterkey=null;
        for (int a = 0; a <= 4; a++) {
            registri[a] = new Registri(0, "r" + a,addresa = new Registri.Adresa(10*(a+1),"0"));
        }
        System.out.println("Unos instrukcija:");
        System.out.println("operacije: mov,add,sub,and,or,not");
        System.out.println("operand1: od R0 do R4");
        System.out.println("operand2: od R0 do R4 ili vrijednost");
        System.out.println("Za debugging podrsku napisati: 'debug from here' ");
        System.out.println("Za prekid debugging-a napisati: 'end debug here' ");
        System.out.println("Za prekid unosa instrukcija napisati:  'end of code' ");
        System.out.println("Unesite instrukcije:");
        while (!(operacija.equals("end")) && !(operand1.equals("of")) && !(operand2.equals("code"))) {
            instrukcija = scan.nextLine();
            if (instrukcija.equals("debug from here")) {
                for (int j = 0; ; ) {
                if(j==0)
                instrukcija = scan.nextLine();
                else
                instrukcija = enterkey;

                    String[] Input = instrukcija.split(" ");
                    operacija = Input[0];
                    operand1 = Input[1];
                    operand2 = Input[2];
                    Registri desReg = null;
                    int c=0,d=0,e=0;

                    for (int b = 0; b <= registri.length-1; b++) {
                        if ((registri[b].getIme().equals(operand1))) {
                            desReg = registri[b];
                            break;
                        }
                        else if(operand1.equals('['+registri[b].getIme()+']')){
                            desReg = registri[b];
                            c++;
                            break;
                        }
                    }
                    try {
                        long value = Long.parseLong(operand2);
                        switch (operacija) {
                            case "mov":
                                if(c==0){
                                    desReg.setValue(value);
                                    break;}
                                else{
                                    desReg.setVal((int)value);
                                break;}
                            case "sub":
                                desReg.setValue(desReg.getValue() - value);
                                break;
                            case "add":
                                desReg.setValue(desReg.getValue() + value);
                                break;
                            case "and":
                                desReg.setValue(desReg.getValue() & value);
                                break;
                            case "or":
                                desReg.setValue(desReg.getValue() | value);
                                break;
                            case "not":
                                if(operand2.equals(":"))
                                desReg.setValue(~desReg.getValue());
                                break;
                        }
                    } catch (NumberFormatException exp) {
                        Registri sourceReg = null;
                        for (int b = 0; b <= registri.length-1; b++) {
                            if (registri[b].getIme().equals(operand2)) {
                                sourceReg = registri[b];
                                e++;
                                break;
                            }else if(operand2.equals('['+registri[b].getIme()+']')){
                                sourceReg = registri[b];
                                d++;
                                break;}
                        }
                        switch (operacija) {
                            case "mov":
                                if(e!=0 && c!=0){
                                    desReg.setVal((int)sourceReg.getValue());
                                    break;
                                }
                                else if (d == 0){
                                    desReg.setValue(sourceReg.getValue());
                                    break;}
                                else{
                                    desReg.setValue(sourceReg.getVal());
                                    break;
                                }
                            case "sub":
                                desReg.setValue(desReg.getValue() - sourceReg.getValue());
                                break;
                            case "add":
                                desReg.setValue(desReg.getValue() + sourceReg.getValue());
                                break;
                            case "and":
                                desReg.setValue(desReg.getValue() & sourceReg.getValue());
                                break;
                            case "or":
                                desReg.setValue(desReg.getValue() | sourceReg.getValue());
                                break;
                            case "not":
                                if(operand2.equals(":"))
                                    desReg.setValue(~desReg.getValue());
                                break;

                    }

                }


                    System.out.println("Stanja registara:");
                    for (int i = 0; i < registri.length; i++) {
                        System.out.format(" %s %10d  [%s] (%s)=%d \n", registri[i].getIme(), registri[i].getValue(), registri[i].value64bit(), registri[i].Adrese(),registri[i].getVal());
                    }
                    enterkey = scan.nextLine();
                    if(enterkey.equals("end of code"))
                        System.exit(0);
                    if (!enterkey.equals("end debug here")) {
                        j++;
                    }
                    else break;
            }
            }
             if (instrukcija.equals("end of code")) {
                break;
            } else {
                String[] Input = instrukcija.split(" ");
                operacija = Input[0];
                operand1 = Input[1];
                operand2 = Input[2];
                Registri desReg = null;
                int c=0,d=0,e=0;

                for (int b = 0; b <= registri.length-1; b++) {
                    if ((registri[b].getIme().equals(operand1))) {
                        desReg = registri[b];
                        break;
                    }
                    else if(operand1.equals('['+registri[b].getIme()+']')){
                        desReg = registri[b];
                        c++;
                        break;
                    }
                }
                try {
                    long value = Long.parseLong(operand2);
                    switch (operacija) {
                        case "mov":
                            if(c==0){
                            desReg.setValue(value);
                            break;}
                            else{
                                desReg.setVal((int)value);
                            break;}
                        case "sub":
                            desReg.setValue(desReg.getValue() - value);
                            break;
                        case "add":
                            desReg.setValue(desReg.getValue() + value);
                            break;
                        case "and":
                            desReg.setValue(desReg.getValue() & value);
                            break;
                        case "or":
                            desReg.setValue(desReg.getValue() | value);
                            break;
                        case "not":
                            if(operand2.equals(":"))
                                desReg.setValue(~desReg.getValue());
                            break;
                    }
                } catch (NumberFormatException exp) {
                    Registri sourceReg = null;
                    for (int j = 0; j <= registri.length-1; j++) {
                        if (registri[j].getIme().equals(operand2)) {
                            sourceReg = registri[j];
                            e++;
                            break;
                        }
                        else if(operand2.equals('['+registri[j].getIme()+']')){
                            sourceReg = registri[j];
                            d++;
                            break;
                        }
                    }
                    switch (operacija) {
                        case "mov":
                            if(e!=0 && c!=0){
                                desReg.setVal((int)sourceReg.getValue());
                                break;
                            }
                            else if (d == 0){
                            desReg.setValue(sourceReg.getValue());
                            break;}
                            else{
                            desReg.setValue(sourceReg.getVal());
                            break;
                            }
                        case "sub":
                            desReg.setValue(desReg.getValue() - sourceReg.getValue());
                            break;
                        case "add":
                            desReg.setValue(desReg.getValue() + sourceReg.getValue());
                            break;
                        case "and":
                            desReg.setValue(desReg.getValue() & sourceReg.getValue());
                            break;
                        case "or":
                            desReg.setValue(desReg.getValue() | sourceReg.getValue());

                    }
                }

            }}
            scan.close();
            System.out.println("Stanja registara:");
            for (int j = 0; j < registri.length; j++)
                System.out.format(" %s %10d  [%s] (%s) = %d  \n", registri[j].getIme(), registri[j].getValue(), registri[j].value64bit(),registri[j].Adrese(),registri[j].getVal());


        }
    }
