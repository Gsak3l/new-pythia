package MVC.Model;

import java.io.Serializable;

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
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getOnomateponumo() {
        return onomateponumo;
    }

    public void setOnomateponumo(String onomateponumo) {
        this.onomateponumo = onomateponumo;
    }

    public String getTilefwno() {
        return tilefwno;
    }

    public void setTilefwno(String tilefwno) {
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
