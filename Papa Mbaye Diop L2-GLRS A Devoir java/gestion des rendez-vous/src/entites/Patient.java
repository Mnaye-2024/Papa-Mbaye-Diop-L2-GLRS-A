package entites;

public class Patient {
    private String nomComplet;
    private String tel;
    private String numero;

    private static int compteur = 1;

    public Patient(String nomComplet, String tel) {
        this.nomComplet = nomComplet;
        this.tel = tel;
        this.numero = generateNumero();
    }

    private String generateNumero() {
        String numero = "PAT" + String.format("%04d", compteur);
        compteur++;
        return numero;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public String getTel() {
        return tel;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "nomComplet='" + nomComplet + '\'' +
                ", tel='" + tel + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
