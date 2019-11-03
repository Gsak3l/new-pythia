import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
        student.add(new Foititis(usernameStd, passStd, mailStd, onomateponumoStd, thlefwnoStd, AMstd, tmhmaStd, eksaminoStd, dieythinsiStd));
        showStd();
    }

    public void createProf(String usernameProf, String passProf, String mailProf, String onomateponumoProf,
                           String thlefwnoProf, String idikotitaProf, String tmimaProf) {
        professor.add(new Kathigitis(usernameProf, passProf, mailProf, onomateponumoProf, thlefwnoProf, idikotitaProf, tmimaProf));
        showProf();
    }

    public void createLesson(String lessonName, int lessonEksamino, String eidosEksaminou, int kodikosMathimatos, String kateuthinsi) {
        lesson.add(new Mathima(lessonName, lessonEksamino, eidosEksaminou, kodikosMathimatos, kateuthinsi));
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