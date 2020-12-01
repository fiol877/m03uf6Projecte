package cat.copernic.m03uf06review.orm;

import java.sql.Date;

/**
 *
 * @author Bernat
 */
public class Registre {
    private Integer id;
    private String nom;
    private String recomenat;
    private Double nota;
    private Boolean venta;
    private Date releaseDate;

    public Registre(Integer id, String nom, String recomenat, Double nota, Boolean venta, Date releaseDate) {
        this.id = id;
        this.nom = nom;
        this.recomenat = recomenat;
        this.nota = nota;
        this.venta = venta;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getRecomenat() {
        return recomenat;
    }

    public Double getNota() {
        return nota;
    }

    public Boolean isVenta() {
        return venta;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "Registre{" + "id=" + id + ", nom=" + nom + ", recomenat=" + recomenat + ", nota=" + nota + ", venta=" + venta + ", releaseDate=" + releaseDate + '}';
    }


}
