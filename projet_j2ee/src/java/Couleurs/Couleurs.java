/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Couleurs;

import Vente.Vente;
import Vetement.Vetement;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Val Gros Pénis
 */
@Entity
@Table(name = "couleurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Couleurs.findAll", query = "SELECT c FROM Couleurs c"),
    @NamedQuery(name = "Couleurs.findByIdCouleur", query = "SELECT c FROM Couleurs c WHERE c.idCouleur = :idCouleur"),
    @NamedQuery(name = "Couleurs.findByCouleur", query = "SELECT c FROM Couleurs c WHERE c.couleur = :couleur")})
public class Couleurs implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCouleur")
    private List<Vente> venteList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCouleur")
    private Integer idCouleur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "couleur")
    private String couleur;

    public Couleurs() {
    }

    public Couleurs(Integer idCouleur) {
        this.idCouleur = idCouleur;
    }

    public Couleurs(Integer idCouleur, String couleur) {
        this.idCouleur = idCouleur;
        this.couleur = couleur;
    }

    public Integer getIdCouleur() {
        return idCouleur;
    }

    public void setIdCouleur(Integer idCouleur) {
        this.idCouleur = idCouleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCouleur != null ? idCouleur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Couleurs)) {
            return false;
        }
        Couleurs other = (Couleurs) object;
        return !((this.idCouleur == null && other.idCouleur != null) || (this.idCouleur != null && !this.idCouleur.equals(other.idCouleur)));
    }

    @Override
    public String toString() {
        return couleur;
    }

    @XmlTransient
    public List<Vente> getVenteList() {
        return venteList;
    }

    public void setVenteList(List<Vente> venteList) {
        this.venteList = venteList;
    }
    
}
