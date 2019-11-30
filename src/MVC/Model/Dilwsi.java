package MVC.Model;

import java.io.Serializable;

public class Dilwsi implements Serializable{
    private float vathmos;
    private Foititis std;
    private Mathima mathima;
    private String hmeromExetasis;
    private String hmeromDilwsis;

    public Dilwsi(String hmeromDilwsis, Foititis std, Mathima mathima) {
        this.hmeromDilwsis = hmeromDilwsis;
        this.std = std;
        this.mathima = mathima;
    }

    public Mathima getMathima() {
        return mathima;
    }

    public String getHmeromDilwsis() {
        return hmeromDilwsis;
    }
    
    
}
