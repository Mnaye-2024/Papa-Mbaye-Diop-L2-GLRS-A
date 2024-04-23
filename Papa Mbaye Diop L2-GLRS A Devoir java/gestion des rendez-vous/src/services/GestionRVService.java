package services;

import entites.Patient;
import entites.DemandeRV;
import enums.Specialite;
import enums.Etat;


public class GestionRVService {
    private int n;
    private Patient[] tabPatients = new Patient[10];
    public DemandeRV[] tabDemandesRV = new DemandeRV[10];

    public void ajouterPatient(Patient patient) {
        if (n < 10) {
            tabPatients[n++] = patient;
        }
    }

    public void listerPatients() {
        for (int i = 0; i < n; i++) {
            System.out.println(tabPatients[i].toString());
        }
    }

    public void enregistrerRV(Patient patient, DemandeRV demandeRV) {
        if (n < 10) {
            tabDemandesRV[n++] = demandeRV;
        }
    }

    public void listerRVParEtat(Etat etat) {
        for (int i = 0; i < n; i++) {
            if (tabDemandesRV[i] != null && tabDemandesRV[i].getEtat() == etat) {
                System.out.println(tabDemandesRV[i].toString());
            }
        }
    }

    public void listerRVParSpecialite(Specialite specialite) {
        for (int i = 0; i < n; i++) {
            if (tabDemandesRV[i] != null && tabDemandesRV[i].getSpecialite() == specialite) {
                System.out.println(tabDemandesRV[i].toString());
            }
        }
    }

    public void traiterRV(DemandeRV demandeRV, Etat etat) {
        for (int i = 0; i < n; i++) {
            if (tabDemandesRV[i] == demandeRV) {
                tabDemandesRV[i].setEtat(etat);
                break;
            }
        }
    }
}
