package TD;

import java.util.ArrayList;

public class Etudiant extends Personne {
    // les attributs
    private String matricul;
    private ArrayList<Note> notes = new ArrayList<>();

    // constructeur avec tous les arguments
    public Etudiant(String matricul, String nom, String prenom) {
        super(nom,prenom);
        this.matricul = matricul;
    }

    // construteur avec 2 argument
    public Etudiant(String nom, String prenom) {
        super(nom,prenom);
    }

    // la  nomComplet
    public String nomComplet() {

        return " matricul : " + matricul +super.nomComplet() ;
    }

    public void ajoudeNotes(Note note) {
        notes.add(note);
    }

    public double moyenne() {
        double somme = 0;
        if (notes.isEmpty()) {
            return 0;
        }
        for (Note note : notes) {
            somme += note.getValeur();
        }
        return somme = somme / notes.size();
    }

    @Override
    public String toString() {
        return " Etudiant : " + nomComplet() + " | Moyenne : " + moyenne();
    }


    // la partie de getteurs est les setteurs

    public String getMatricul() {
        return matricul;
    }

    public void setMatricul(String matricul) {
        this.matricul = matricul;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void affichageBulletin(){
        System.out.println("*************************  Bulletin De Note  *************************");
        System.out.printf("* %-66s *\n",nomComplet().toUpperCase());
        System.out.println("**********************************************************************\n");
        for (Note n : notes ){
            System.out.printf("\t\t\t* %-35s *\n\n",n);
        }
        System.out.println(" Moyenne : "+moyenne());
        System.out.println(" Mention : "+mention().toUpperCase()+"\n");
        System.out.println("**********************************************************************\n");
    }
    public String mention(){
        if (moyenne() <10){
            return " Insuffisant";
        } else if (moyenne() < 12) {
            return " Passable";
        } else if (moyenne() < 14) {
            return " Assez Bien";
        } else if (moyenne() < 16) {
            return " Bien";
        } else if (moyenne() < 18) {
            return " Tres Bien";
        }
        else {
            return "Excellent";
        }
    }

}
