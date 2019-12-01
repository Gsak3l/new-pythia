package MVC.Model;

import MVC.View_Controller.NewJFrame;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Foititis extends Account {
    private int AM;
    private List <Dilwsi> dilwseis = new ArrayList<>(); 
    
    public Foititis(String username, String password, String onomateponumo, int AM) {
        super(username, password, onomateponumo);
        this.AM = AM;
    }
    
    public boolean addDilwsi(Mathima mathima, String hmeromDilwsis) {
        if (elegxosData(mathima)){
            Dilwsi dilwsi = new Dilwsi(hmeromDilwsis, this, mathima);
            dilwseis.add(dilwsi);
            updateStdFile(getStdFromFile()); 
            return true;
        }
        else {
            System.out.println("H dhlwsh toy mathimatos apetyxe");
            return false;
        }
    }
    
    public boolean addVathmos(Mathima math, String hmeromEksetashs, float vathmos){
        if(!elegxosVathmoy(vathmos)){
            return false;
        }
        Dilwsi dilwsi = null;
        for(int i = 0; i < dilwseis.size(); i++) {
            if (dilwseis.get(i).getMathima().getTitlos().equals(math.getTitlos())){
                dilwsi = dilwseis.get(i);
                dilwseis.remove(i);
                break;
            }
        }
        if(dilwsi != null){
            dilwsi.setVathmos(hmeromEksetashs, vathmos);
            dilwseis.add(dilwsi);
            updateStdFile(getStdFromFile()); 
            return true;
        }
        System.out.println("H vathmologia toy mathimatos apetyxe");
        return false;
    }
    
    public boolean elegxosVathmoy(float vathmos){
        if (vathmos>=0 && vathmos<=10){
            return true;
        }
        return false;
    }
    
    public boolean elegxosData(Mathima mathima){
        if (mathima instanceof Theoria){
            System.out.println("Eimai theoria");
            for(Dilwsi dilwsi : dilwseis){
                if (((Theoria) mathima).hasProapaitoumena()){
                    List<Mathima> proap = ((Theoria) mathima).getProap();
                    if(elegxosPerasmenonProap(proap)){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                if (dilwsi.getMathima().getKwdikos().equals(mathima.getKwdikos())){
                    System.out.println("Yparxo hdh sth lista theoria");
                    return false;
                }
            }
        }
        else if (mathima instanceof Ergastirio){
            System.out.println("Eimai erg");
            String kwdikos = mathima.getKwdikos();
            String kwdikosTheorias = kwdikos.substring(0, kwdikos.length()-1)+"Θ";
            boolean flag = false;
            for(Dilwsi dilwsi : dilwseis){
                if (dilwsi.getMathima().getKwdikos().equals(mathima.getKwdikos())){
                    System.out.println("Yparxo hdh sth lista erg");
                    return false;
                }
                if (dilwsi.getMathima().getKwdikos().equals(kwdikosTheorias)){
                    System.out.println("Yparxei to theoritiko kommati sth lista erg");
                    flag = true;
                }
            }
            return flag;
        }
        return true;
    }
    
    public boolean elegxosPerasmenonProap(List<Mathima> proap){
        boolean flagDilwsis = false;
        for (Mathima math : proap){
            for (Dilwsi dilwsi : dilwseis){
                if (dilwsi.getMathima().getTitlos().equals(math.getTitlos())){
                    if(dilwsi.getVathmos()<5){
                        return false;
                    }
                    flagDilwsis = true;
                }
            }
            if (!flagDilwsis){
                return false;
            }
        }
        return true;
    }
    
    
    public void updateStdFile(List<Foititis> stds){
        FileOutputStream f=null;
        ObjectOutputStream o=null;
        File file = new File("Foithtes.txt");
        if (file.exists()){
            try {
                f = new FileOutputStream(file);
                o = new ObjectOutputStream(f);  
                for (Foititis std : stds){
                   o.writeObject(std);
                }   
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try{
                    o.close();
                    f.close();
                    System.out.println("ekleisa");
                }catch(IOException ex) {
                    System.err.println("An IOException was caught: " + ex.getMessage());
                }
            }
        }
        else {
            System.out.println("Den yparxei to arxeio");
        }
    }
    
    public List<Foititis> getStdFromFile(){
        List<Foititis> student = new ArrayList<>();
        FileInputStream fi = null;
        ObjectInputStream oi = null;
        File file = new File("Foithtes.txt");        
        Account a;
        if (file.exists()){
            try{
                fi = new FileInputStream(file);
                oi = new ObjectInputStream(fi);
                while (true){
                    try{
                      a = (Account)oi.readObject();
                      if (a instanceof Foititis){
                          if(a.getUsername().equals(this.getUsername())){
                              System.out.println("Ego eimai");
                              student.add(this);
                          }
                          else{
                            student.add((Foititis)a);
                          }
                      }
                    }catch (EOFException ex1) {
                        break; //EOF reached.
                    }catch (IOException ex2) {
                        System.err.println("An IOException was caught: " + ex2.getMessage());
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try{
                    oi.close();
                    fi.close();
                    System.out.println("ekleisa");
                }catch(IOException ex) {
                    System.err.println("An IOException was caught: " + ex.getMessage());
                }
            }
            return student;
        }
        else{
            return null;
        }
    }
    
    
    public int getAM(){
        return this.AM;
    }
    public boolean getDilwsi(String kodMath){
        for(Dilwsi dil:dilwseis) {
            if(dil.getMathima().getKwdikos().equals(kodMath)) {
                return true;
            }
        }
        return false;
    }
    public String getDilwseis() {
        String olo = "";        
        for(Dilwsi dil:dilwseis){
            String mathima = String.valueOf(dil.getMathima());
            String hmerom = String.valueOf(dil.getHmeromDilwsis());
            olo += mathima+":"+hmerom+"\n";
        }
        return olo;
    }
    public List<Dilwsi> getDilwsi3(){
        return dilwseis;
    }
    public Dilwsi getDilwsi2(String kodMath){
        for(Dilwsi dil:dilwseis) {
            if(dil.getMathima().getKwdikos().equals(kodMath)) {
                return dil;
            }
        }
        return null;
    }

    public void setDilwseis(List<Dilwsi> dilwseis) {
        this.dilwseis = dilwseis;
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