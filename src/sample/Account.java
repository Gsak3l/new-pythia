package sample;

/*----------Account----------*/
class Account {
    private String username;
    private String password;
    private String mail;
    private String onomateponumo;
    private String idiotita;
    private int tilefwno;

    public Account(String username, String password, String mail, String onomateponumo, String idiotita, int tilefwno) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.onomateponumo = onomateponumo;
        this.idiotita = idiotita;
        this.tilefwno = tilefwno;
    }

    public String getIdiotita() {
        return "";
    }
}

/*----------Admin----------*/
class Admin extends Account {
    public boolean dilwseis;
    public Admin(String username, String password, String mail, String onomateponumo, String idiotita, int tilefwno) {
        super(username, password, mail, onomateponumo, idiotita, tilefwno);
    }

    public String getIdiotita() {
        return "Administrator";
    }

    public void dimiourgiaKathigiti() {

    }

    public void dimiourgiaFoititi() {

    }

}

/*----------Kathigitis----------*/
class Kathigitis extends Account {
    private String eidikotita;
    private String tmima;

    public Kathigitis(String username, String password, String mail, String onomateponumo, String idiotita, int tilefwno, String eidikotita, String tmima) {
        super(username, password, mail, onomateponumo, idiotita, tilefwno);
        this.eidikotita = eidikotita;
        this.tmima = tmima;
    }

    public String getIdiotita() {
        return "Professor";
    }
}

class Foititis extends Account {
    private int AM;
    private String tmima;
    private int eksamino;
    private String dieuthinsi;
    private int deiktisProodou;
    private StoixeiaEggrafis stoixeiaEggrafis;

    public Foititis(String username, String password, String mail, String onomateponumo, String idiotita, int tilefwno, int AM, String tmima, int eksamino, String dieuthinsi, int deiktisProodou, StoixeiaEggrafis stoixeiaEggrafis) {
        super(username, password, mail, onomateponumo, idiotita, tilefwno);
        this.AM = AM;
        this.tmima = tmima;
        this.eksamino = eksamino;
        this.dieuthinsi = dieuthinsi;
        this.deiktisProodou = deiktisProodou;
        this.stoixeiaEggrafis = stoixeiaEggrafis;
    }
}




