import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Account implements Serializable {
    private String username;
    private String password;
    private String mail;
    private String onomateponumo;
    private String idiotita;
    private String tilefwno;

    public Account(String username, String password, String mail, String onomateponumo, String tilefwno) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.onomateponumo = onomateponumo;
        this.tilefwno = tilefwno;
    }

    public String getIdiotita() {
        return "";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}

class Admin extends Account {
    private boolean dilwseis = false;
    private List<Kathigitis> professor = new ArrayList<>();
    private List<Foititis> student = new ArrayList<>();
    private List<Mathima> lesson = new ArrayList<>();

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
                           String thlefwnoProf, String idikotitaProf, String tmimaProf) {
        Kathigitis prof = new Kathigitis(usernameProf, passProf, mailProf, onomateponumoProf, thlefwnoProf, idikotitaProf, tmimaProf);
        professor.add(prof);
        putProfToList(prof);
    }

    public void createLesson(String lessonName, int lessonEksamino, String eidosEksaminou, int kodikosMathimatos, String kateuthinsi) {
        Mathima math = new Mathima(lessonName, lessonEksamino, eidosEksaminou, kodikosMathimatos, kateuthinsi);
        lesson.add(math);
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
    
    public void showStd() {
        Foititis f1 = student.get(0);
        System.out.println(f1);
    }

    public void showProf() {
        Kathigitis p1 = professor.get(0);
        System.out.println(p1);
    }

    public void showLesson() {
        Mathima m1 = lesson.get(0);
        System.out.println(m1);
    }
}

class Kathigitis extends Account {
    private String eidikotita;
    private String tmima;

    public Kathigitis(String username, String password, String mail, String onomateponumo, String tilefwno, String eidikotita, String tmima) {
        super(username, password, mail, onomateponumo, tilefwno);
        this.eidikotita = eidikotita;
        this.tmima = tmima;
    }

    public String getIdiotita() {
        return "Professor";
    }

    public String toString() {
        return this.getUsername();
    }
}

class Foititis extends Account {
    private int AM;
    private String tmima;
    private int eksamino;
    private String dieuthinsi;
    //private StoixeiaEggrafis stoixeiaEggrafis;

    public Foititis(String username, String password, String mail, String onomateponumo, String tilefwno, int AM, String tmima, int eksamino, String dieuthinsi) {
        super(username, password, mail, onomateponumo, tilefwno);
        this.AM = AM;
        this.tmima = tmima;
        this.eksamino = eksamino;
        this.dieuthinsi = dieuthinsi;
        //this.stoixeiaEggrafis = stoixeiaEggrafis;
    }

    public String getIdiotita() {
        return "Student";
    }

    public String toString() {
        return this.getUsername();
    }
}