package MVC.Model;

import java.util.ArrayList;
import java.util.List;

public class Foititis extends Account {
    private int AM;
    private List <Dilwsi> dilwseis = new ArrayList<>(); 
    
    public Foititis(String username, String password, String onomateponumo, int AM) {
        super(username, password, onomateponumo);
        this.AM = AM;
    }
    
    public void addDilwsi(Mathima mathima, String hmeromDilwsis) {
//        Dilwsi dilwsi = new Dilwsi();
//        if(this.getEksamino()%2 == 0) {
//            dilwsi.eisagwgiDhlwsh("Earino", this, mathimataDhlwshs);
//        }
//        else {
//            dilwsi.eisagwgiDhlwsh("Xeimerino", this, mathimataDhlwshs);
//        }
//        dilwseis.add(dilwsi);
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