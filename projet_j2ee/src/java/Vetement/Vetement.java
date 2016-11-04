/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vetement;

import Vente.Vente;
import Stock.Stock;
import Couleurs.Couleurs;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author sabat
 */
@Entity
@Table(name = "vetement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vetement.findAll", query = "SELECT v FROM Vetement v"),
    @NamedQuery(name = "Vetement.findByRefVet", query = "SELECT v FROM Vetement v WHERE v.refVet = :refVet"),
    @NamedQuery(name = "Vetement.findByTextile", query = "SELECT v FROM Vetement v WHERE v.textile = :textile"),
    @NamedQuery(name = "Vetement.findByPrixV", query = "SELECT v FROM Vetement v WHERE v.prixV = :prixV"),
    @NamedQuery(name = "Vetement.findByUrlV", query = "SELECT v FROM Vetement v WHERE v.urlV = :urlV")})
public class Vetement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "refVet")
    private Integer refVet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "textile")
    private String textile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixV")
    private float prixV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "urlV")
    private String urlV;
    @JoinColumn(name = "couleur", referencedColumnName = "couleur")
    @ManyToOne(optional = false)
    private Couleurs couleur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vetement")
    private Collection<Stock> stockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refVet")
    private Collection<Vente> venteCollection;

    public Vetement() {
    }

    public Vetement(Integer refVet) {
        this.refVet = refVet;
    }

    public Vetement(Integer refVet, String textile, float prixV, String urlV) {
        this.refVet = refVet;
        this.textile = textile;
        this.prixV = prixV;
        this.urlV = urlV;
    }

    public Integer getRefVet() {
        return refVet;
    }

    public void setRefVet(Integer refVet) {
        this.refVet = refVet;
    }

    public String getTextile() {
        return textile;
    }

    public void setTextile(String textile) {
        this.textile = textile;
    }

    public float getPrixV() {
        return prixV;
    }

    public void setPrixV(float prixV) {
        this.prixV = prixV;
    }

    public String getUrlV() {
        return urlV;
    }

    public void setUrlV(String urlV) {
        this.urlV = urlV;
    }

    public Couleurs getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleurs couleur) {
        this.couleur = couleur;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    @XmlTransient
    public Collection<Vente> getVenteCollection() {
        return venteCollection;
    }

    public void setVenteCollection(Collection<Vente> venteCollection) {
        this.venteCollection = venteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refVet != null ? refVet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vetement)) {
            return false;
        }
        Vetement other = (Vetement) object;
//        if ((this.refVet == null && other.refVet != null)
//                || (this.refVet != null && !this.refVet.equals(other.refVet))) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Vetement[ refVet=" + refVet + " ]";
    }
    
}
