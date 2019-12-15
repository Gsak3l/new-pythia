import java.util.ArrayList;
import MVC.Model.*;

public class mainProgram {

    public static void main(String[] args) {
//        
//        // User story 1: Εγγραφή φοιτητή (βλ. Πίνακα 1)
        ArrayList <Foititis> foitites = new  ArrayList<>(3);
        foitites.add(new Foititis("it151234", "123", "Αθανασίου Κίμων", 151234));
        foitites.add(new Foititis("it163217", "123", "Βασιλειάδου Δανάη", 163217));
        foitites.add(new Foititis("it172278", "123", "Γεωργίου Αλκης", 172278));
//        
//        // User story 2: Εισαγωγή μαθήματος (βλ. Πίνακα 2)
        ArrayList <Mathima> mathimata = new  ArrayList<>();
        Theoria theoriaAS = new Theoria("1205-Θ", "Αντικειμενοστρεφής Προγραμματισμός (Θ)");
        Ergastirio ergastirioAS = new Ergastirio("1205-Ε", "Αντικειμενοστρεφής Προγραμματισμός (E)");
        Theoria theoriaDD = new Theoria("1305-Θ", "Δομές Δεδομένων και Ανάλυση Αλγορίθμων (Θ)");
        Theoria theoriaML = new Theoria("1742-Θ", "Μηχανική Λογισμικού (Θ)");
        
        // User story 3: Εισαγωγή προαπαιτούμενων μαθήματος (βλ. Πίνακα 2)
        mathimata.add(theoriaAS);
        mathimata.add(ergastirioAS);
        theoriaDD.addProapaitoumeno(theoriaAS);
        mathimata.add(theoriaDD);
        theoriaML.addProapaitoumeno(theoriaAS);
        theoriaML.addProapaitoumeno(theoriaDD);
        mathimata.add(theoriaML);
//        
//        // User story 4: Δήλωση μαθήματος από φοιτητή (βλ. Πίνακα 3)
//        // User story 5: Εισαγωγή βαθμολογίας (από γραμματεία)
        foitites.get(0).addDilwsi(mathimata.get(0), "20/2/2019"); 
        foitites.get(0).addVathmos(mathimata.get(0), "15/7/2019", (float) 8.0);
        foitites.get(0).addDilwsi(mathimata.get(2), "25/9/2019");
        foitites.get(0).addDilwsi(mathimata.get(3), "26/9/2019");
        
        foitites.get(1).addDilwsi(mathimata.get(1), "20/2/2019"); 
        foitites.get(1).addDilwsi(mathimata.get(2), "20/2/2019"); 
        foitites.get(1).addDilwsi(mathimata.get(3), "20/2/2019"); 
        
        foitites.get(2).addDilwsi(mathimata.get(0), "22/2/2019");
        foitites.get(2).addVathmos(mathimata.get(0), "17/5/2019", (float) 7.0);
        foitites.get(2).addDilwsi(mathimata.get(2), "20/9/2019");
        foitites.get(2).addVathmos(mathimata.get(2), "21/9/2019", (float) 4.0);
        foitites.get(2).addDilwsi(mathimata.get(3), "28/9/2019");
        
        
//        // User story 6: Εκτύπωση Αναλυτικής κατάστασης φοιτητή
        for (Foititis foititis : foitites) {
            foititis.showStatus();
            // εμφανίζει τα στοιχεία του
            // εμφανίζει κάθε μάθημα που δήλωσε και έχει πάρει βαθμό (βλ. Πίνακα 4)
        }
    }
     
}
