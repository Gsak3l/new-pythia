package MVC.Model;

import MVC.View_Controller.NewJFrame;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kathigitis extends Account {
    private String eidikotita;
    private String tmima;
    private List<Mathima> mathimata = new ArrayList<>();

    public Kathigitis(String username, String password, String onomateponumo, String eidikotita, String tmima, List<Mathima> mathimata) {
        super(username, password, onomateponumo);
        this.eidikotita = eidikotita;
        this.tmima = tmima;
        this.mathimata = mathimata;
    }

    public String getEidikotita() {
        return eidikotita;
    }

    public void setEidikotita(String eidikotita) {
        this.eidikotita = eidikotita;
    }

    public String getTmima() {
        return tmima;
    }

    public void setTmima(String tmima) {
        this.tmima = tmima;
    }

    public List<Mathima> getMathimata() {
        return mathimata;
    }

    public void setMathimata(List<Mathima> mathimata) {
        this.mathimata = mathimata;
    }
    
    @Override
    public String getIdiotita() {
        return "Professor";
    }

    @Override
    public String toString() {
        return this.getUsername();
    }
    
}