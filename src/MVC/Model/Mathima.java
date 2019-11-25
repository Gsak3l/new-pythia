package MVC.Model;

import java.io.Serializable;

public class Mathima implements Serializable{
    private String onomaMathimatos;
    private int eksamino;
    private int kodikosMathimatos;
    private String tmhmaMathimatos;
    private String typosMathimatos;
    private int didaktikesMonades;
    
    public Mathima(String onomaMathimatos, int eksamino, int kodikosMathimatos, String tmhmaMathimatos, String typosMathimatos, int didaktikesMonades) {
        this.onomaMathimatos = onomaMathimatos;
        this.eksamino = eksamino;
        this.kodikosMathimatos = kodikosMathimatos;
        this.tmhmaMathimatos = tmhmaMathimatos;
        this.typosMathimatos = typosMathimatos;
        this.didaktikesMonades = didaktikesMonades;
    }

    @java.lang.Override
    public String toString() {
        return "Mathima(" + "onomaMathimatos=" + onomaMathimatos + ", eksamino=" + eksamino + ", kodikosMathimatos=" + kodikosMathimatos +  ", tmhmaMathimatos=" + tmhmaMathimatos + ", typosMathimatos=" + typosMathimatos + "didaktikesMonades" + didaktikesMonades +")";
    }

    public String getOnomaMathimatos() {
        return onomaMathimatos;
    }
    
    public void setOnomaMathimatos(String onomaMathimatos) {
        this.onomaMathimatos = onomaMathimatos;
    }
    
    public int getEksamino() {
        return eksamino;
    }
    
    public void setEksamino(int eksamino) {
        this.eksamino = eksamino;
    }
    
    public int getKodikosMathimatos() {
        return kodikosMathimatos;
    }
    
    public void setKodikosMathimatos(int kodikosMathimatos) {
        this.kodikosMathimatos = kodikosMathimatos;
    }

    public String getTmhmaMathimatos() {
        return tmhmaMathimatos;
    }

    public void setTmhmaMathimatos(String tmhmaMathimatos) {
        this.tmhmaMathimatos = tmhmaMathimatos;
    }

    public String getTyposMathimatos() {
        return typosMathimatos;
    }

    public void setTyposMathimatos(String typosMathimatos) {
        this.typosMathimatos = typosMathimatos;
    }

    public int getDidaktikesMonades() {
        return didaktikesMonades;
    }

    public void setDidaktikesMonades(int didaktikesMonades) {
        this.didaktikesMonades = didaktikesMonades;
    }
}