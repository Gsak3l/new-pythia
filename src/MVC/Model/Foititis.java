package MVC.Model;

import java.util.ArrayList;
import java.util.List;

public class Foititis extends Account {
    private int AM;
    private String tmima;
    private int eksamino;
    private String dieuthinsi;
    private StoixeiaEggrafis stoixeiaEggrafis = null;
    private List <Dhlwsh> dilwsi = new ArrayList<>(); 
    
    public Foititis(String username, String password, String mail, String onomateponumo, String tilefwno, int AM, String tmima, int eksamino, String dieuthinsi, StoixeiaEggrafis stoixeiaEggrafis) {
        super(username, password, mail, onomateponumo, tilefwno);
        this.AM = AM;
        this.tmima = tmima;
        this.eksamino = eksamino;
        this.dieuthinsi = dieuthinsi;
        this.stoixeiaEggrafis = stoixeiaEggrafis;
    }

    public Foititis(String username, String password, String mail, String onomateponumo, String tilefwno, int AM, String tmima, int eksamino, String dieuthinsi) {
        super(username, password, mail, onomateponumo, tilefwno);
        this.AM = AM;
        this.tmima = tmima;
        this.eksamino = eksamino;
        this.dieuthinsi = dieuthinsi;
    }
    
    public void addDhlwsh(List<Mathima> mathimataDhlwshs) {
        Dhlwsh dhlwsh = new Dhlwsh();
        if(this.getEksamino()%2 == 0) {
            dhlwsh.eisagwgiDhlwsh("Earino", this, mathimataDhlwshs);
        }
        else {
            dhlwsh.eisagwgiDhlwsh("Xeimerino", this, mathimataDhlwshs);
        }
        dilwsi.add(dhlwsh);
    }
    
    public String getTmima() {
        return tmima;
    }

    public StoixeiaEggrafis getStoixeiaEggrafis() {
        return stoixeiaEggrafis;
    }
    
    public void setTmima(String tmima) {
        this.tmima = tmima;
    }

    public int getEksamino() {
        return eksamino;
    }

    public void setEksamino(int eksamino) {
        this.eksamino = eksamino;
    }

    public String getDieuthinsi() {
        return dieuthinsi;
    }

    public void setDieuthinsi(String dieuthinsi) {
        this.dieuthinsi = dieuthinsi;
    }
    
    public int getAM(){
        return this.AM;
    }
    
    public void setAM(int AM) {
        this.AM = AM;
    }
    
    @Override
    public String getIdiotita() {
        return "Student";
    }

    @Override
    public String toString() {
        return this.getUsername();
    }
}