package TD;

public class Enseignat extends Personne{
    // les attributs
    private String matiere;
    public Enseignat(String nom, String prenom, String matiere) {
        super(nom,prenom);
        this.matiere = matiere;
    }

    public Enseignat(String nom, String prenom) {
        super(nom,prenom);
    }

    public String nomComplet() {
        return super.nomComplet()+" Matiere : "+matiere;
    }
    // les geturs et le seteurs

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

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    @Override
    public String toString() {
        return "Nom : " + getNom() + "\nPrenom : " + getPrenom() + "\nMatiere : " + getMatiere()+"\n";
    }
}
