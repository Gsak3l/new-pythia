/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stini
 */
public class Kathigitis extends Account {
    private String eidikotita;
    private String tmima;
    private List<Mathima> mathimata = new ArrayList<>();

    public Kathigitis(String username, String password, String mail, String onomateponumo, String tilefwno, String eidikotita, String tmima, List<Mathima> mathimata) {
        super(username, password, mail, onomateponumo, tilefwno);
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
    
    public String getIdiotita() {
        return "Professor";
    }

    public String toString() {
        return this.getUsername();
    }
}