import java.util.Scanner;
import entites.DemandeRV;
import entites.Patient;
import enums.Etat;
import enums.Specialite;
import services.GestionRVService;
import services.GestionRVVue;

public class App {
    public static void main(String[] args) {
        GestionRVVue.setScanner(new Scanner(System.in));
        GestionRVService service = new GestionRVService();

        boolean quitter = false;
        while (!quitter) {
            GestionRVVue.afficherMenuPrincipal();
            int choix = GestionRVVue.scanner.nextInt();
            GestionRVVue.scanner.nextLine(); 

            switch (choix) {
                case 1:
                    Patient patient = GestionRVVue.saisiePatient();
                    service.ajouterPatient(patient);
                    break;
                case 2:
                    service.listerPatients();
                    break;
                case 3:
                    Patient patientRV = GestionRVVue.saisiePatient();
                    DemandeRV demandeRV = GestionRVVue.saisieDemandeRV();
                    service.enregistrerRV(patientRV, demandeRV);
                    break;
                case 4:
                    System.out.println("Choisissez l'état (1. En cours, 2. Valider, 3. Annuler) : ");
                    int choixEtat = GestionRVVue.scanner.nextInt();
                    GestionRVVue.scanner.nextLine();
                    Etat etat = choixEtat == 1 ? Etat.ENCOURS : choixEtat == 2 ? Etat.VALIDE : Etat.ANNULE;
                    service.listerRVParEtat(etat);
                    break;
                case 5:
                    Specialite specialite = GestionRVVue.choisirSpecialite();
                    service.listerRVParSpecialite(specialite);
                    break;
                case 6:
                    System.out.println("Entrez l'indice de la demande de RV à traiter : ");
                    int indiceRV = GestionRVVue.scanner.nextInt();
                    GestionRVVue.scanner.nextLine();
                    DemandeRV demandeTraitee = service.tabDemandesRV[indiceRV];
                    System.out.println("Choisissez l'état du RV (1. En cours, 2. Valider, 3. Annuler) : ");
                    int choixEtatRV = GestionRVVue.scanner.nextInt();
                    GestionRVVue.scanner.nextLine();
                    Etat etatRV = choixEtatRV == 1 ? Etat.ENCOURS : choixEtatRV == 2 ? Etat.VALIDE : Etat.ANNULE;
                    service.traiterRV(demandeTraitee, etatRV);
                    break;
                case 7:
                    quitter = true;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez choisir une option valide.");
                    break;
            }
        }
    }
}
