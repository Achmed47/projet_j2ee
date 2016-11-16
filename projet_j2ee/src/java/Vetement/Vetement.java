/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vetement;

import Types.Types;
import Vente.Vente;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
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

/**
 *
 * @author Val Gros Pénis
 */
@Entity
@Table(name = "vetement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vetement.findAll", query = "SELECT v FROM Vetement v"),
    @NamedQuery(name = "Vetement.findByRefVet", query = "SELECT v FROM Vetement v WHERE v.refVet = :refVet"),
    @NamedQuery(name = "Vetement.findByPrixV", query = "SELECT v FROM Vetement v WHERE v.prixV = :prixV"),
    @NamedQuery(name = "Vetement.findByUrlV", query = "SELECT v FROM Vetement v WHERE v.urlV = :urlV")})
public class Vetement implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refVet")
    private List<Vente> venteList;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "refVet")
    private Integer refVet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixV")
    private float prixV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "urlV")
    private String urlV;
    @JoinColumn(name = "idType", referencedColumnName = "idType")
    @ManyToOne(optional = false)
    private Types idType;

    public Vetement() {
        Random randomGenerator = new Random();
        this.refVet = randomGenerator.nextInt(9999999);
    }

    public Vetement(Integer refVet) {
        this.refVet = refVet;
    }

    public Vetement(Integer refVet, float prixV, String urlV) {
        this.refVet = refVet;
        this.prixV = prixV;
        this.urlV = urlV;
    }

    public Integer getRefVet() {
        return refVet;
    }

    public void setRefVet(Integer refVet) {
        this.refVet = refVet;
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

    public Types getType() {
        return idType;
    }

    public void setType(Types idType) {
        this.idType = idType;
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
        if ((this.refVet == null && other.refVet != null) || (this.refVet != null && !this.refVet.equals(other.refVet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vetement.Vetement[ refVet=" + refVet + ", " + idType + ", " + prixV + ", " + urlV + " ]";
    }

    public List<Vente> getVenteList() {
        return venteList;
    }

    public void setVenteList(List<Vente> venteList) {
        this.venteList = venteList;
    }
}
