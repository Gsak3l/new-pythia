package MVC.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mathima implements Serializable{
    private String titlos;
    private String kwdikos;
    //private List<Mathima> proapaitoumena = new ArrayList<>();
    
    public Mathima(String kodikosMathimatos, String onomaMathimatos) {
        this.titlos = onomaMathimatos;
        this.kwdikos = kodikosMathimatos;
    }
    
    @Override
    public String toString() {
        return "Mathima{" + "kwdikos=" + kwdikos + ", titlos=" + titlos + '}';
    }
    public String getTitlos() {
        return titlos;
    }
    
    public String getKwdikos() {
        return kwdikos;
    }
}