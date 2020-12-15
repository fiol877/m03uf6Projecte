package cat.copernic.m03uf06review.hibernate_relational;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
public class Registre2 {
    private Integer id;
    private String nom;
    private String recomenat;
    private Double nota;
    private Boolean venta;
    private Date releaseDate;
    private Set categoria;

    public Registre2() {}
    public Registre2(Integer id, String nom, String recomenat, Double nota, Boolean venta, Date releaseDate) {
        this.id = id;
        this.nom = nom;
        this.recomenat = recomenat;
        this.nota = nota;
        this.venta = venta;
        this.releaseDate = releaseDate;
    }
    
    public Registre2(String nom, String recomenat, Double nota, Boolean venta, Date releaseDate) {
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

    public Boolean getVenta() {
        return venta;
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

    public Set getCategoria() {
        return categoria;
    }

    public void setCategoria(Set categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Registre2{" + "id=" + id + ", nom=" + nom + ", recomenat=" + recomenat + ", nota=" + nota + ", venta=" + venta + ", releaseDate=" + releaseDate + ", categoria=" + categoria + '}';
    }
    
    
}
