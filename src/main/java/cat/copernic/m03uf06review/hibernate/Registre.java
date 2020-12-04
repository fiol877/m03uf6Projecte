package cat.copernic.m03uf06review.hibernate;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 

/**
 *
 * @author Bernat
 */

/*@Entity
@Table(name = "jocs")
public class Registre {
    @Id
    @Column(name = "id_joc")
    private int id;
 
    @Column(name = "nom_joc")
    private String nom;
 
    @Column(nullable = true, name = "recomenat")
    private String recomenat;
 
    @Column(nullable = true, name = "nota_joc")
    private Double nota;
    
    @Column(nullable = true, name = "a_la_venta")
    private Boolean venta;
    
    @Column(nullable = true, name = "recomenat")
    private Date releaseDate;
    
    public Registre() {
    }

    public int getId() {
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

    public Boolean getVenta() {
        return venta;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
    
    */


@javax.persistence.Table(name = "jocs")
public class Registre {
    private Integer id;
    private String nom;
    private String recomenat;
    private Double nota;
    private Boolean venta;
    private Date releaseDate;

    public Registre() {}
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRecomenat(String recomenat) {
        this.recomenat = recomenat;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public void setVenta(Boolean venta) {
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
