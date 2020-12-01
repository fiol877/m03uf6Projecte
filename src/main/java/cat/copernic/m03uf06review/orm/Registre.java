package cat.copernic.m03uf06review.orm;

import java.sql.Date;

/**
 *
 * @author Bernat
 */
public class Registre {
    int id;
    String nom;
    char recomenat;
    double nota;
    boolean venta;
    Date releaseDate;

    public Registre(int id, String nom, char recomenat, double nota, boolean venta, Date releaseDate) {
        this.id = id;
        this.nom = nom;
        this.recomenat = recomenat;
        this.nota = nota;
        this.venta = venta;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public char getRecomenat() {
        return recomenat;
    }

    public double getNota() {
        return nota;
    }

    public boolean isVenta() {
        return venta;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRecomenat(char recomenat) {
        this.recomenat = recomenat;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setVenta(boolean venta) {
        this.venta = venta;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Registre{" + "id=" + id + ", nom=" + nom + ", recomenat=" + recomenat + ", nota=" + nota + ", venta=" + venta + ", releaseDate=" + releaseDate + '}';
    }
    
    
}
