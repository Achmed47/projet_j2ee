/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Couleurs;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import Vetement.Vetement;

/**
 *
 * @author sabat
 */
@Entity
@Table(name = "couleurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Couleurs.findAll", query = "SELECT c FROM Couleurs c"),
    @NamedQuery(name = "Couleurs.findByCouleur", query = "SELECT c FROM Couleurs c WHERE c.couleur = :couleur")})
public class Couleurs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "couleur")
    private String couleur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "couleur")
    private Collection<Vetement> vetementCollection;

    public Couleurs() {
    }

    public Couleurs(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @XmlTransient
    public Collection<Vetement> getVetementCollection() {
        return vetementCollection;
    }

    public void setVetementCollection(Collection<Vetement> vetementCollection) {
        this.vetementCollection = vetementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couleur != null ? couleur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Couleurs)) {
            return false;
        }
        Couleurs other = (Couleurs) object;
        if ((this.couleur == null && other.couleur != null) || (this.couleur != null && !this.couleur.equals(other.couleur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Couleurs[ couleur=" + couleur + " ]";
    }
    
}
