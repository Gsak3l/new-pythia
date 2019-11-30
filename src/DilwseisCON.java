import java.util.ArrayList;
import MVC.Model.*;
import java.util.List;

public class DilwseisCON {

    public static void main(String[] args) {
        String kwdikos = "1205-Ε";
        String newKwdikos = kwdikos.substring(0, kwdikos.length()-1)+"Θ";
        System.out.println(newKwdikos);
//        
//        // User story 1: Εγγραφή φοιτητή (βλ. Πίνακα 1)
//        ArrayList <Foititis> foitites = new  ArrayList<>(3);
//        foitites.add(new Foititis("it151234", "123", "Αθανασίου Κίμων", 151234));
//        foitites.add(new Foititis("it163217", "123", "Βασιλειάδου Δανάη", 163217));
//        foitites.add(new Foititis("it162278", "123", "Γεωργίου Αλκης", 162278));
//        
//        // User story 2: Εισαγωγή μαθήματος (βλ. Πίνακα 2)
//        ArrayList <Mathima> mathimata = new  ArrayList<>();
//        Theoria theoriaAS = new Theoria("1205-Θ", "Αντικειμενοστρεφής Προγραμματισμός (Θ)");
//        Ergastirio ergastirioAS = new Ergastirio("1205-Ε", "Αντικειμενοστρεφής Προγραμματισμός (E)");
//        
//        Theoria theoriaDD = new Theoria("1305-Θ", "Δομές Δεδομένων και Ανάλυση Αλγορίθμων (Θ)");
//        Theoria theoriaML = new Theoria("1742-Θ", "Μηχανική Λογισμικού (Θ)");
//        
//        // User story 3: Εισαγωγή προαπαιτούμενων μαθήματος (βλ. Πίνακα 2)
//        theoriaDD.addProapaitoumeno(theoriaAS);
//        mathimata.add(theoriaDD);
//        theoriaML.addProapaitoumeno(theoriaAS);
//        theoriaML.addProapaitoumeno(theoriaDD);
//        mathimata.add(theoriaML);
//        
//        // User story 4: Δήλωση μαθήματος από φοιτητή (βλ. Πίνακα 3)
//        // User story 5: Εισαγωγή βαθμολογίας (από γραμματεία)
//        foitites.get(0).addDilwsi(theoriaAS, "20/2/2019"); 
//        //foitites.get(0).addVathmos(theoriaAS, "15/7/2019", 8.0);
//        
//        // User story 6: Εκτύπωση Αναλυτικής κατάστασης φοιτητή
//        for (Foititis foititis : foitites) {
//            // εμφανίζει τα στοιχεία του
//            // εμφανίζει κάθε μάθημα που δήλωσε και έχει πάρει βαθμό (βλ. Πίνακα 4)
//        }
    }
     
}
