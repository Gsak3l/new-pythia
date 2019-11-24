package MVC.Model;

import java.util.ArrayList;
import java.util.List;

public class Dhlwsh {
    private String eidosEksaminou;
    private Foititis std;
    private List<DhlwmenoMathima> dhlwmenaMathimata = new ArrayList<>();

    public void eisagwgiDhlwsh(String eidosEksaminou, Foititis std, List<Mathima> mathimata) {
        this.eidosEksaminou = eidosEksaminou;
        this.std = std;
    }
    
}
