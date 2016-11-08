/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tailles;

import Vente.Vente;
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
@Table(name = "tailles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tailles.findAll", query = "SELECT t FROM Tailles t"),
    @NamedQuery(name = "Tailles.findByIdTaille", query = "SELECT t FROM Tailles t WHERE t.idTaille = :idTaille"),
    @NamedQuery(name = "Tailles.findByTaille", query = "SELECT t FROM Tailles t WHERE t.taille = :taille")})
public class Tailles implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTaille")
    private List<Vente> venteList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTaille")
    private Integer idTaille;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "taille")
    private String taille;

    public Tailles() {
    }

    public Tailles(Integer idTaille) {
        this.idTaille = idTaille;
    }

    public Tailles(Integer idTaille, String taille) {
        this.idTaille = idTaille;
        this.taille = taille;
    }

    public Integer getIdTaille() {
        return idTaille;
    }

    public void setIdTaille(Integer idTaille) {
        this.idTaille = idTaille;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTaille != null ? idTaille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tailles)) {
            return false;
        }
        Tailles other = (Tailles) object;
        if ((this.idTaille == null && other.idTaille != null) || (this.idTaille != null && !this.idTaille.equals(other.idTaille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return taille;
    }

    @XmlTransient
    public List<Vente> getVenteList() {
        return venteList;
    }

    public void setVenteList(List<Vente> venteList) {
        this.venteList = venteList;
    }
    
}
