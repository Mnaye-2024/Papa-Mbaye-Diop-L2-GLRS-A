package services;

import java.util.Scanner;
import entites.DemandeRV;
import entites.Patient;
import enums.Specialite;
import enums.Etat;

public class GestionRVVue {
    public static Scanner scanner = new Scanner(System.in);

    public static void setScanner(Scanner scanner) {
        GestionRVVue.scanner = scanner;
    }

    public static Patient saisiePatient() {
        System.out.println("Entrez le nom complet du patient : ");
        String nomComplet = scanner.nextLine();
        System.out.println("Entrez le numéro de téléphone du patient : ");
        String tel = scanner.nextLine();
        return new Patient(nomComplet, tel);
    }

    public static DemandeRV saisieDemandeRV() {
        System.out.println("Entrez la date (jj/mm/aaaa) : ");
        String dateStr = scanner.nextLine();
        System.out.println("Entrez l'heure (hh:mm) : ");
        String heure = scanner.nextLine();
        System.out.println("Entrez le motif : ");
        String motif = scanner.nextLine();
        System.out.println("Choisissez la spécialité : ");
        Specialite specialite = choisirSpecialite();
        return new DemandeRV(dateStr, heure, motif, specialite);
    }

    public static Specialite choisirSpecialite() {
        System.out.println("1. Cardiologie");
        System.out.println("2. Ophtalmologie");
        System.out.println("3. Urologie");
        int choix = scanner.nextInt();
        scanner.nextLine();
        switch (choix) {
            case 1:
                return Specialite.CARDIOLOGIE;
            case 2:
                return Specialite.OPHTALMOLOGIE;
            case 3:
                return Specialite.UROLOGIE;
            default:
                System.out.println("Choix invalide, veuillez choisir une spécialité valide.");
                return choisirSpecialite();
        }
    }

    public static Etat choisirEtat() {
        System.out.println("1. En cours");
        System.out.println("2. Valider");
        System.out.println("3. Annuler");
        int choix = scanner.nextInt();
        scanner.nextLine(); 
        switch (choix) {
            case 1:
                return Etat.ENCOURS;
            case 2:
                return Etat.VALIDE;
            case 3:
                return Etat.ANNULE;
            default:
                System.out.println("Choix invalide, veuillez choisir un état valide.");
                return choisirEtat();
        }
    }

    public static void afficherMenuPrincipal() {
        System.out.println("Menu Principal : ");
        System.out.println("1. Ajouter un patient dans le tableau");
        System.out.println("2. Lister tous les patients du tableau");
        System.out.println("3. Enregistrer un RV pour un patient");
        System.out.println("4. Lister tous les RV par Etat");
        System.out.println("5. Lister tous les RV par Spécialité");
        System.out.println("6. Traiter un RV");
        System.out.println("7. Quitter");
        System.out.println("Choisissez une option : ");
        System.out.println("-------------------------------------------------------");
    }
}
