package cat.copernic.m03uf06review.hibernate_relational;

import cat.copernic.m03uf06review.hibernate.Registre;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Categoria {
    private int id;
    private String nom;

    public Categoria() {
    }

    public Categoria(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
      tmp = ( id + nom ).hashCode();
      return tmp;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      if (!this.getClass().equals(obj.getClass())) return false;

      Categoria obj2 = (Categoria)obj;
      if((this.id == obj2.getId()) && (this.nom.equals(obj2.getNom()))) {
         return true;
      }
      return false;
    }
}
