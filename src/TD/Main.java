package TD;

import java.util.*;

public class Main {
    public ArrayList<Enseignat> enseignats = new ArrayList<>();
    public ArrayList<Etudiant> etudiants = new ArrayList<>();
    public ArrayList<Personne> personnes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().menuPrincipal();
    }

    void menuPrincipal() {
        int choix;
        do {
            affichageMenu();
            choix = Integer.parseInt(sc.nextLine());
            switch (choix) {
                case 1: saisieEnseignat(); break;
                case 2: saisieEtudiant(); break;
                case 3: afficherEnseignat(); break;
                case 4: afficherEtudiant(); break;
                case 5: rechercherEtudiant(); break;
                case 6: rechercherEnseignant(); break;
                case 7: saisieNote(); break;
                case 8: generBulletin(); break;
                case 9: modifierEtudiant(); break;
                case 10: modifierEnseignat(); break;
                case 11: supprimerEnseignat(); break;
                case 12: afficherAnnuaire(); break;
                case 0: System.out.println("Bye Bye !!!!!!!!"); break;
                default: System.out.println("Choix invalide, réessaye !");
            }
        } while (choix != 0);
    }

    // 1- MENU
    public void affichageMenu() {
        System.out.println("======================== Menu de L'Application ========================");
        System.out.println("1. Saisir Enseignant");
        System.out.println("2. Saisir Etudiant");
        System.out.println("3. Afficher Enseignant");
        System.out.println("4. Afficher Etudiant");
        System.out.println("5. Rechercher Etudiant Par Matricule");
        System.out.println("6. Rechercher Enseignant Par Nom");
        System.out.println("7. Ajout des Notes");
        System.out.println("8. Generer Bulletin");
        System.out.println("9. Modifier Etudiant");
        System.out.println("10. Modifier Enseignant");
        System.out.println("11. Supprimer Enseignant");
        System.out.println("12. Afficher annuaire");
        System.out.println("0. Quitter");
        System.out.println("================================================");
        System.out.print("Votre Choix : ");
    }

    //  - CREATE ENSEIGNANT
    public void saisieEnseignat() {
        int continuer = 0;
        System.out.println("------------------ Saisie Enseignant ------------------");
        do {
            System.out.print("Nom : ");
            String nom = sc.nextLine();
            System.out.print("Prenom : ");
            String prenom = sc.nextLine();
            System.out.print("Matiere : ");
            String matiere = sc.nextLine();
            Enseignat ens1 = new Enseignat(nom, prenom, matiere);
            enseignats.add(ens1);
            personnes.add(ens1);
            System.out.println("Enseignant Ajoute");
            System.out.println("Cliquer 1 pour continuer 0 pour Quitter");
            continuer = Integer.parseInt(sc.nextLine());
        } while (continuer == 1);
        System.out.println("_____________ FIN SAISIE ENSEIGNANT _____________\n");
    }
//        saisis etudiant
    public void saisieEtudiant() {
        String matricul, nom, prenom;
        int coninuer = 0;
        System.out.println("------------------ Saisi Etudiant ------------------");
        do {
            System.out.print("Matricul : ");
            matricul = sc.nextLine();
            System.out.print("Nom : ");
            nom = sc.nextLine();
            System.out.print("Prenom : ");
            prenom = sc.nextLine();
            Etudiant e1 = new Etudiant(matricul, nom, prenom);
            etudiants.add(e1);
            personnes.add(e1);
            System.out.println("Etudiant Ajoute");
            System.out.println(" Cliquer 1 pour continuer 0 pour Quitter");
            coninuer = Integer.parseInt(sc.nextLine());

        } while (coninuer == 1);
        System.out.println("_____________ FIN SAISE Etudiant _____________\n");
    }

    //  - READ ENSEIGNANT
    public void afficherEnseignat() {
        System.out.println("--------------------- AFFICHAGE ENSEIGNANT ---------------------\n");
        if (enseignats.isEmpty()) {
            System.out.println("Aucun Enseignant !!!!!!!!!");
        } else {
            for (Enseignat e : enseignats) {
                System.out.println(e);
            }
        }
        System.out.println("_____________ FIN AFFICHAGE ENSEIGNANT _____________\n");
    }

    // - Affichage de Etudiant

    public void afficherEtudiant() {
        System.out.println("--------------------- AFFICHAGE ETUDIANT ---------------------\n ");
        if (etudiants.isEmpty()) {
            System.out.println("Aucun Etudiant !!!!!!!!!!!!");
        } else {
            for (Etudiant etudiant : etudiants) {
                System.out.println(etudiant);
            }
            System.out.println("_____________ FIN  AFFICHAGE ETUDIANT _____________\n");
        }
    }
    // Recherche Etudiant par matricule
    public Etudiant rechercherParMatricul(String matricul) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getMatricul().equals(matricul)) {
                return etudiant;
            }
        }
        return null;
    }

    public void rechercherEtudiant() {
        System.out.print("Matricule a rechercher : ");
        String matricul = sc.nextLine();
        Etudiant e = rechercherParMatricul(matricul);
        if (e == null) {
            System.out.println("Il n'existe pas d'etudiant avec le matricule " + matricul);
        } else {
            System.out.println(e);
        }
        System.out.println("_____________ FIN RECHERCHE ETUDIANT _____________\n");
    }

    // Recherche Enseignant par nom
    public Enseignat rechercherEnseignatParNom(String nom) {
        for (Enseignat enseignat : enseignats) {
            if (enseignat.getNom().equalsIgnoreCase(nom)) {
                return enseignat;
            }
        }
        return null;
    }

    public void rechercherEnseignant() {
        System.out.print("Nom a rechercher : ");
        String nom = sc.nextLine();
        Enseignat enseignat = rechercherEnseignatParNom(nom);
        if (enseignat == null) {
            System.out.println("Il n'existe pas d'enseignant avec le nom " + nom);
        } else {
            System.out.println(enseignat);
        }
        System.out.println("_____________ FIN RECHERCHE ENSEIGNANT _____________\n");
    }

    //  - saisie notes
    public void saisieNote() {
        System.out.print("Matricule : ");
        String matricul = sc.nextLine();
        Etudiant e = rechercherParMatricul(matricul);
        if (e == null) {
            System.out.println("Etudiant introuvable");
        } else {
            int continuer = 0;
            do {
                System.out.print("Matiere : ");
                String matiere = sc.nextLine();
                System.out.print("Valeur : ");
                double valeur = Double.parseDouble(sc.nextLine());
                Note n = new Note(matiere, valeur);
                e.ajoudeNotes(n);
                System.out.println("----------- Note Ajoutee -----------");
                System.out.println("Cliquer 1 pour continuer 0 pour Quitter");
                continuer = Integer.parseInt(sc.nextLine());
            } while (continuer == 1);
            System.out.println("_____________ FIN SAISIE NOTE _____________\n");
        }
    }

    public void generBulletin() {
        System.out.print("Matricule : ");
        String matricul = sc.nextLine();
        Etudiant e = rechercherParMatricul(matricul);
        if (e == null) {
            System.out.println("Impossible de generer le bulletin : " + matricul + " inexistant");
        } else {
            e.affichageBulletin();
        }
    }

    // Modificattion de Etudiant
    public void modifierEtudiant() {
        int continuer = 0;
        String nouveauPrenom, nouveauNom;
        double nouveauMatricule;
        System.out.print("Matricule à rechercher : ");
        String matricule = sc.nextLine();
        Etudiant e = rechercherParMatricul(matricule);
        if (e == null) {
            System.out.println(matricule + " est inexistant");

        } else {
            do {
                e.setMatricul(matricule);
                System.out.print("donnez le nouveau nom : ");
                nouveauNom = sc.nextLine();
                System.out.print("donnez le nouveau prenom : ");
                nouveauPrenom = sc.nextLine();
                e.setNom(nouveauPrenom);
                e.setPrenom(nouveauNom);
                System.out.println("Etudiant modifer avec succes !!!");
                System.out.println(e);
                System.out.println(" Cliquer 1 pour continuer 0 pour Quitter");
                continuer = Integer.parseInt(sc.nextLine());
            } while (continuer == 1);
        }
    }

    //  - UPDATE ENSEIGNANT
    public void modifierEnseignat() {
        System.out.print("Nom a rechercher : ");
        String nom = sc.nextLine();
        Enseignat enseignat = rechercherEnseignatParNom(nom);
        if (enseignat == null) {
            System.out.println(nom + " est inexistant");
        } else {
            System.out.print("Donnez le nouveau nom : ");
            String nouveauNom = sc.nextLine();
            System.out.print("Donnez le nouveau prenom : ");
            String nouveauPrenom = sc.nextLine();
            System.out.print("Donnez la nouvelle Matiere : ");
            String nouveauMatiere = sc.nextLine();

            enseignat.setNom(nouveauNom);
            enseignat.setPrenom(nouveauPrenom);
            enseignat.setMatiere(nouveauMatiere);
            System.out.println("Enseignant modifie avec succes !!!");
            System.out.println(enseignat);
        }
    }

    //  - DELETE ENSEIGNANT - NOUVEAU
    public void supprimerEnseignat() {
        System.out.print("Nom a supprimer : ");
        String nom = sc.nextLine();
        Enseignat enseignat = rechercherEnseignatParNom(nom);
        if (enseignat == null) {
            System.out.println(nom + " est inexistant");
        } else {
            enseignats.remove(enseignat);
            personnes.remove(enseignat);
            System.out.println("Enseignant supprime avec succes !!!");
        }
    }

    public void afficherAnnuaire() {
        System.out.println("--------------- ANNUAIRE ---------------");
        if (personnes.isEmpty()) {
            System.out.println("Annuaire vide !");
        } else {
            for (Personne p : personnes) {
                System.out.println(p);
            }
        }
        System.out.println("_____________ FIN ANNUAIRE _____________\n");
    }
}