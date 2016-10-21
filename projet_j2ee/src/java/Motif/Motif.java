/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motif;

import java.io.Serializable;
import java.util.Collection;
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
import Vente.Vente;

/**
 *
 * @author sabat
 */
@Entity
@Table(name = "motif")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motif.findAll", query = "SELECT m FROM Motif m"),
    @NamedQuery(name = "Motif.findByIdMotif", query = "SELECT m FROM Motif m WHERE m.idMotif = :idMotif"),
    @NamedQuery(name = "Motif.findByUrlMotif", query = "SELECT m FROM Motif m WHERE m.urlMotif = :urlMotif"),
    @NamedQuery(name = "Motif.findByPrixM", query = "SELECT m FROM Motif m WHERE m.prixM = :prixM")})
public class Motif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMotif")
    private Integer idMotif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "urlMotif")
    private String urlMotif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixM")
    private float prixM;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMotif")
    private Collection<Vente> venteCollection;

    public Motif() {
    }

    public Motif(Integer idMotif) {
        this.idMotif = idMotif;
    }

    public Motif(Integer idMotif, String urlMotif, float prixM) {
        this.idMotif = idMotif;
        this.urlMotif = urlMotif;
        this.prixM = prixM;
    }

    public Integer getIdMotif() {
        return idMotif;
    }

    public void setIdMotif(Integer idMotif) {
        this.idMotif = idMotif;
    }

    public String getUrlMotif() {
        return urlMotif;
    }

    public void setUrlMotif(String urlMotif) {
        this.urlMotif = urlMotif;
    }

    public float getPrixM() {
        return prixM;
    }

    public void setPrixM(float prixM) {
        this.prixM = prixM;
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
        hash += (idMotif != null ? idMotif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motif)) {
            return false;
        }
        Motif other = (Motif) object;
        if ((this.idMotif == null && other.idMotif != null) || (this.idMotif != null && !this.idMotif.equals(other.idMotif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Motif[ idMotif=" + idMotif + " ]";
    }
    
}
