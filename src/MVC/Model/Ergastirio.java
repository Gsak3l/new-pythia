package MVC.Model;

import java.util.ArrayList;
import java.util.List;

public class Ergastirio extends Mathima{
    private List<ErgastiriakoTmima> ergTmima = new ArrayList<>(3);
    
    public Ergastirio(String kodikosMathimatos, String onomaMathimatos) {
        super(kodikosMathimatos, onomaMathimatos);
        ergTmima.add(new ErgastiriakoTmima("T1", 25));
        ergTmima.add(new ErgastiriakoTmima("T2", 25));
        ergTmima.add(new ErgastiriakoTmima("T3", 25));
    }
    
    @Override
    public String toString() {
        return "Ergastirio{ " + super.toString() + " }";
    }
}
