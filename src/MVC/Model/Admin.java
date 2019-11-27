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

public class Admin extends Account {
    private boolean dilwseis = true;
    private List<Kathigitis> professor = new ArrayList<>();
    private List<Foititis> student = new ArrayList<>();
    private List<Mathima> course = new ArrayList<>();
    private Admin admin ;
    
    public Admin(String username, String password, String mail, String onomateponumo, String tilefwno) {
        super(username, password, mail, onomateponumo, tilefwno);
    }

    public void setDilwseis(boolean dilwseis) {
        this.dilwseis = dilwseis;
    }
    
    public boolean getDilwseis() {
        return dilwseis;
    }

    @Override
    public String getIdiotita() {
        return "Administrator";
    }

    public void createStd(String usernameStd, String passStd, String mailStd, String onomateponumoStd,
                          String thlefwnoStd, int AMstd, String tmhmaStd, int eksaminoStd, String dieythinsiStd) {
        Foititis std = new Foititis(usernameStd, passStd, mailStd, onomateponumoStd, thlefwnoStd, AMstd, tmhmaStd, eksaminoStd, dieythinsiStd);
        student.add(std);
        putStdToList(std);
    }

    public void createProf(String usernameProf, String passProf, String mailProf, String onomateponumoProf,
                           String thlefwnoProf, String idikotitaProf, String tmimaProf, List<Mathima> mathimataProf) {
        Kathigitis prof = new Kathigitis(usernameProf, passProf, mailProf, onomateponumoProf, thlefwnoProf, idikotitaProf, tmimaProf, mathimataProf);
        professor.add(prof);
        putProfToList(prof);
    }

    public void createCourse(String courseName, int courseEksamino, String courseTmhma, int kodikosMathimatos, String courseTypos, int courseDM) {
        Mathima math = new Mathima(courseName, courseEksamino, kodikosMathimatos, courseTmhma, courseTypos, courseDM);
        course.add(math);
        putMathToList(math);
    }
    
    private void putStdToList(Foititis std) {
        FileOutputStream f = null;
        AppendingObjectOutputStream ao = null;
        ObjectOutputStream o = null;
        try {
            File file = new File("Foithtes.txt");
            if (file.exists()  && !file.isDirectory()){
                System.out.println("Yparxo");
                f = new FileOutputStream(file, true);
                ao = new AppendingObjectOutputStream(f);
                ao.writeObject(std);
            }
            else if (!file.exists()){
                System.out.println("Den yparxo");
                f = new FileOutputStream(file, true);
                o = new ObjectOutputStream(f);
                o.writeObject(std);
            }
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                if (o == null){
                    ao.close();
                }
                else {
                    o.close();
                }
                f.close();
                System.out.println("ekleisa");
            }catch(IOException ex) {
                System.err.println("An IOException was caught: " + ex.getMessage());
            }
        }
    }

    private void putProfToList(Kathigitis prof) {
        FileOutputStream f = null;
        AppendingObjectOutputStream ao = null;
        ObjectOutputStream o = null;
        try {
            File file = new File("Professors.txt");
            if (file.exists()  && !file.isDirectory()){
                System.out.println("Yparxo");
                f = new FileOutputStream(file, true);
                ao = new AppendingObjectOutputStream(f);
                ao.writeObject(prof);
            }
            else if (!file.exists()){
                System.out.println("Den yparxo");
                f = new FileOutputStream(file, true);
                o = new ObjectOutputStream(f);
                o.writeObject(prof);
            }
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                if (o == null){
                    ao.close();
                }
                else {
                    o.close();
                }
                f.close();
                System.out.println("ekleisa");
            }catch(IOException ex) {
                System.err.println("An IOException was caught: " + ex.getMessage());
            }
        }
    }

    private void putMathToList(Mathima math) {
        FileOutputStream f = null;
        AppendingObjectOutputStream ao = null;
        ObjectOutputStream o = null;
        try {
            File file = new File("myCourses.txt");
            if (file.exists()  && !file.isDirectory()){
                System.out.println("Yparxo");
                f = new FileOutputStream(file, true);
                ao = new AppendingObjectOutputStream(f);
                ao.writeObject(math);
            }
            else if (!file.exists()){
                System.out.println("Den yparxo");
                f = new FileOutputStream(file, true);
                o = new ObjectOutputStream(f);
                o.writeObject(math);
            }
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                if (o == null){
                    ao.close();
                }
                else {
                    o.close();
                }
                f.close();
                System.out.println("ekleisa");
            }catch(IOException ex) {
                System.err.println("An IOException was caught: " + ex.getMessage());
            }
        }
    }
    
    public void deleteStd(){
        putStdToFile();
    }
    
    public void deleteProf() {
        putProfToFile();
    }
    
    public void getStdFromFile(){
        student.clear();
        FileInputStream fi = null;
        ObjectInputStream oi = null;
        Account a;
          try{
            fi = new FileInputStream(new File("Foithtes.txt"));
            oi = new ObjectInputStream(fi);
            while (true){
                try{
                  a = (Account)oi.readObject();
                  if (a instanceof Foititis){
                      student.add((Foititis)a);
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
    }
  
    public void getProfFromFile(){
        professor.clear();
        FileInputStream fi = null;
        ObjectInputStream oi = null;
        Account a;
          try{
            fi = new FileInputStream(new File("Foithtes.txt"));
            oi = new ObjectInputStream(fi);
            while (true){
                try{
                  a = (Account)oi.readObject();
                  if (a instanceof Foititis){
                      professor.add((Kathigitis)a);
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
    }
    
    public void getMathimataFromFile(){
        course.clear();
        FileInputStream fi = null;
        ObjectInputStream oi = null;
        Mathima m;
          try{
            fi = new FileInputStream(new File("myCourses.txt"));
            oi = new ObjectInputStream(fi);
            while (true){
                try{
                  m = (Mathima)oi.readObject();
                  course.add(m);
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
    }
        
    public Foititis searchStd(String username){
        getStdFromFile();
        for(int i = 0; i < student.size(); i++) {
            if(student.get(i).getUsername().equals(username)) {
               Foititis std = student.get(i);
               student.remove(i);
               return std;
            }
        }
        System.out.println("O Foititis den vrethike !");
        return null;
    }
    
    public Mathima searchMath(int Kodikos){
        getMathimataFromFile();
        for(int i = 0; i < course.size(); i++) {
            if(course.get(i).getKodikosMathimatos() == Kodikos) {
               Mathima math = course.get(i);
               course.remove(i);
               return math;
            }
        }
        System.out.println("To Mathima den vrethike !");
        return null;
    }
    
    public Kathigitis searchProf(String username){
        getProfFromFile();
        for(int i = 0; i < professor.size(); i++) {
            if(professor.get(i).getUsername().equals(username)) {
               Kathigitis prof = professor.get(i);
               professor.remove(i);
               return prof;
            }
        }
        System.out.println("O Kathigitis den vrethike !");
        return null;
    }
    
    public void updateMath(String courseName, int courseEksamino, String courseTmhma, int kodikosMathimatos, String courseTypos, int courseDM){
        Mathima math = new Mathima(courseName,courseEksamino,kodikosMathimatos,courseTmhma,courseTypos,courseDM);
        course.add(math);
        putMathimataToFile();
    }
    
    public void updateStd(String usernameStd, String passStd, String mailStd, String onomateponumoStd,
                           String thlefwnoStd, int AMstd, String tmhmaStd, int eksaminoStd, String dieythinsiStd){
        Foititis std = new Foititis(usernameStd, passStd, mailStd, onomateponumoStd, thlefwnoStd, AMstd, tmhmaStd, eksaminoStd, dieythinsiStd);     
        student.add(std);
        putStdToFile();
    }
    
    public void updateProf(String usernameProf, String passProf, String mailProf, String onomateponumoProf,
                           String thlefwnoProf, String tmhmaProf, String eidikothtaProf, List<Mathima> mathimataProf){
        Kathigitis prof = new Kathigitis(usernameProf, passProf, mailProf, onomateponumoProf, thlefwnoProf, tmhmaProf, eidikothtaProf, mathimataProf);     
        professor.add(prof);
        putProfToFile();
    }
    
    public void putStdToFile(){
        FileOutputStream f=null;
        ObjectOutputStream o=null;
        try {
            f = new FileOutputStream(new File("Foithtes.txt"));
            o = new ObjectOutputStream(f);  
            for (Foititis std : this.student){
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
   
    public void putProfToFile(){
        FileOutputStream f=null;
        ObjectOutputStream o=null;
        try {
            f = new FileOutputStream(new File("Professors.txt"));
            o = new ObjectOutputStream(f);
            for (Kathigitis prof : this.professor){
               o.writeObject(prof);
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
    
    public void putMathimataToFile(){
        FileOutputStream f=null;
        ObjectOutputStream o=null;
        try {
            f = new FileOutputStream(new File("myCourses.txt"));
            o = new ObjectOutputStream(f);
            for (Mathima math : this.course){
               o.writeObject(math);
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
    
    public void putAdminToFile(){
        FileOutputStream f=null;
        ObjectOutputStream o=null;
        try {
            f = new FileOutputStream(new File("Admin.txt"));
            o = new ObjectOutputStream(f);
            o.writeObject(this);
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
    
    public void deleteCourse(){
        putMathimataToFile();
    }

    public boolean updateDhlwseis(){
        if(this.getDilwseis()){
            this.setDilwseis(false);
        }
        else{
            this.setDilwseis(true);
        }
        putAdminToFile();
        return this.getDilwseis();
    }
}
