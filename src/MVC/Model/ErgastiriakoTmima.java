package MVC.Model;

import java.io.Serializable;

public class ErgastiriakoTmima implements Serializable{
    private String tmima;
    private int theseis;
    
    public ErgastiriakoTmima(String tmima, int theseis){
        this.tmima = tmima;
        this.theseis = theseis;
    }
}
