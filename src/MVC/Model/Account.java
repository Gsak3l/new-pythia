package MVC.Model;

import java.io.Serializable;

public class Account implements Serializable {
    private String username;
    private String password;
    private String onomateponumo;
    private String idiotita;

    public Account(String username, String password, String onomateponumo) {
        this.username = username;
        this.password = password;
        this.onomateponumo = onomateponumo;
    }

    public String getOnomateponumo() {
        return onomateponumo;
    }

    public void setOnomateponumo(String onomateponumo) {
        this.onomateponumo = onomateponumo;
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
