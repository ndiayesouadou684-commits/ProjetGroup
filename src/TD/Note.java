package TD;

public class Note {
    // les attributs
    String matiers;
    double valeur;

    // le contructeur
    public Note(String matiers, double valeur) {
        this.matiers = matiers;
        this.valeur = valeur;
    }

    public String getMatiers() {
        return matiers;
    }

    public void setMatiers(String matiers) {
        this.matiers = matiers;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        if (valeur < 0 || valeur > 20) {
            System.out.println("la valeur n'est pas valide");
            this.valeur = 0;
        } else {
            this.valeur = valeur;
        }
    }

    @Override
    public String toString() {
        return  getMatiers()+" *** "+getValeur();
    }
}