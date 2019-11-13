/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author stini
 */
public class Admin extends Account {
    private boolean dilwseis = false;
    private List<Kathigitis> professor = new ArrayList<>();
    private List<Foititis> student = new ArrayList<>();
    private List<Mathima> course = new ArrayList<>();
    private List<Admin> admin = new ArrayList<>();
    
    public Admin(String username, String password, String mail, String onomateponumo, String tilefwno) {
        super(username, password, mail, onomateponumo, tilefwno);
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
        FileOutputStream f=null;
        AppendingObjectOutputStream o=null;
        try {
            f = new FileOutputStream(new File("myAccounts.txt"), true);
            o = new AppendingObjectOutputStream(f);
            o.writeObject(std);
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

    private void putProfToList(Kathigitis prof) {
        FileOutputStream f=null;
        AppendingObjectOutputStream o=null;
        try {
            f = new FileOutputStream(new File("myAccounts.txt"), true);
            o = new AppendingObjectOutputStream(f);
            o.writeObject(prof);
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
    
    public void deleteStd(String userName){
        for(int i = 0; i < student.size(); i ++) {
            if(student.get(i).getUsername().equals(userName)) {
                student.remove(i);
                System.out.println("Epituxis Diagrafi tou Foititi me AM: " + userName);
            }
        }
        putAccountsToFile();
    }
    
    public void deteteProf(String username) {
        for(int i = 0; i < professor.size(); i++) {
            if(professor.get(i).getUsername().equals(username)) {
                professor.remove(i);
                System.out.println("Epituxis Diagrafi tou Kathigiti me username: " + username);
            }else {
                System.out.println("Apotixis Diagrafi tou Kathigiti me username: " + username);
            }
        }
    }
    
    public void getAccountsFromFile(){
        student.clear();
        professor.clear();
        
        FileInputStream fi = null;
        ObjectInputStream oi = null;
        Account a;
        
          try{
            fi = new FileInputStream(new File("myAccounts.txt"));
            oi = new ObjectInputStream(fi);
            
            while (true){
                try{
                    
                  a = (Account)oi.readObject();
                  if (a instanceof Foititis){
                      student.add((Foititis)a);
                  }else if(a instanceof Kathigitis){
                      professor.add((Kathigitis)a);
                  }else{
                      admin.add((Admin)a);
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
    
    public Foititis searchStd(String username){
        getAccountsFromFile();
        for(int i = 0; i < student.size(); i++) {
            if(student.get(i).getUsername().equals(username)) {
               Foititis std = student.get(i);
               student.remove(i);
               return std;
            }else{
                System.out.println("O Foititis den vrethike !");
            }
        }
        return null;
    }
    
    public void updateStd(String usernameStd, String passStd, String mailStd, String onomateponumoStd,
                           String thlefwnoStd, int AMstd, String tmhmaStd, int eksaminoStd, String dieythinsiStd){
        Foititis Std = new Foititis(usernameStd, passStd, mailStd, onomateponumoStd, thlefwnoStd, AMstd, tmhmaStd, eksaminoStd, dieythinsiStd);     
        student.add(Std);
        putAccountsToFile();
    }
    
    public void putAccountsToFile(){
        
        FileOutputStream f=null;
        ObjectOutputStream o=null;
        try {
            f = new FileOutputStream(new File("myAccounts.txt"));
            o = new ObjectOutputStream(f);
            
            for (Admin admin : this.admin){
               o.writeObject(admin);
            }   
            for (Kathigitis prof : this.professor){
               o.writeObject(prof);
            }   
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
    
    public void deleteCourse(int kodM) {
        for(int i = 0; i < course.size(); i ++) {
            if(course.get(i).getKodikosMathimatos() == kodM) {
                course.remove(i);
                System.out.println("Epituxis Diagrafi tou Mathimatos me kodiko: " + kodM);
            }else {
                System.out.println("Apotuxia diagrafis tou mathimatos me kodiko: " + kodM);
            }
        }
    }
    
    public void showStd() {
        Foititis f1 = student.get(0);
        System.out.println(f1);
    }

    public void showProf() {
        Kathigitis p1 = professor.get(0);
        System.out.println(p1);
    }

    public void showcourse() {
        Mathima m1 = course.get(0);
        System.out.println(m1);
    }
}
