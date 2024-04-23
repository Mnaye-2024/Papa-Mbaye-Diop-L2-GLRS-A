package entites;

import enums.Etat;
import enums.Specialite;

public class DemandeRV {
    private String date; // Changer le type de Date en String
    private String heure;
    private String motif;
    private Specialite specialite;
    private Etat etat;

    public DemandeRV(String date, String heure, String motif, Specialite specialite) {
        this.date = date;
        this.heure = heure;
        this.motif = motif;
        this.specialite = specialite;
        this.etat = Etat.ENCOURS;
    }
    

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getMotif() {
        return motif;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "DemandeRV{" +
                "date='" + date + '\'' +
                ", heure='" + heure + '\'' +
                ", motif='" + motif + '\'' +
                ", specialite=" + specialite +
                ", etat=" + etat +
                '}';
    }
}
