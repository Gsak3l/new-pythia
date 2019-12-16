package MVC.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mathima implements Serializable{
    private String titlos;
    private String kwdikos;
    
    public Mathima(String kodikosMathimatos, String onomaMathimatos) {
        this.titlos = onomaMathimatos;
        this.kwdikos = kodikosMathimatos;
    }
    
    @Override
    public String toString() {
        return " Κωδικός : " + kwdikos + " Τίτλος : " + titlos;
    }
    public String getTitlos() {
        return titlos;
    }
    
    public String getKwdikos() {
        return kwdikos;
    }
}