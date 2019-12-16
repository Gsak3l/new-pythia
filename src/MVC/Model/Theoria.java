package MVC.Model;

import java.util.ArrayList;
import java.util.List;

public class Theoria extends Mathima{
    private List<Mathima> proapaitoumena = new ArrayList<>();
    
    public Theoria(String kodikosMathimatos, String onomaMathimatos) {
        super(kodikosMathimatos, onomaMathimatos);
    }
    
    public Theoria(String kodikosMathimatos, String onomaMathimatos, List<Mathima> proap) {
        super(kodikosMathimatos, onomaMathimatos);
        this.proapaitoumena = proap;
    }
    
    public void addProapaitoumeno(Mathima mathima){
        proapaitoumena.add(mathima);
    }
    
    public List<Mathima> getProap(){
        return proapaitoumena;
    }
    
    public boolean hasProapaitoumena(){
        return !proapaitoumena.isEmpty();
    }
    
    public String getProapaitoumena(){
        String s="";
        for (Mathima proapaitoumeno : proapaitoumena){
            s+= proapaitoumeno.getTitlos() + "\n";
        }
        return s;
    }
    
    @Override
    public String toString() {
        return "Θεωρία [ " + super.toString()+ " ] ";
    }
   

    
}
