/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tailles;

import Stock.Stock;
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
import Vente.Vente;

/**
 *
 * @author sabat
 */
@Entity
@Table(name = "tailles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tailles.findAll", query = "SELECT t FROM Tailles t"),
    @NamedQuery(name = "Tailles.findByTaille", query = "SELECT t FROM Tailles t WHERE t.taille = :taille")})
public class Tailles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "taille")
    private String taille;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tailles")
    private Collection<Stock> stockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taille")
    private Collection<Vente> venteCollection;

    public Tailles() {
    }

    public Tailles(String taille) {
        this.taille = taille;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
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
        hash += (taille != null ? taille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tailles)) {
            return false;
        }
        Tailles other = (Tailles) object;
        if ((this.taille == null && other.taille != null) || (this.taille != null && !this.taille.equals(other.taille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Tailles[ taille=" + taille + " ]";
    }
    
}
