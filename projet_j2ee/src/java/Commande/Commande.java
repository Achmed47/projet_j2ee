/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import Client.Client;
import Dates.Dates;
import Vetement.Vetement;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Val Gros Pénis
 */
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByIdCommande", query = "SELECT c FROM Commande c WHERE c.idCommande = :idCommande"),
    @NamedQuery(name = "Commande.findByStatut", query = "SELECT c FROM Commande c WHERE c.statut = :statut")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCommande")
    private Integer idCommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "statut")
    private short statut;
    @JoinColumn(name = "refVet", referencedColumnName = "refVet")
    @ManyToOne(optional = false)
    private Vetement refVet;
    @JoinColumn(name = "refClient", referencedColumnName = "refClient")
    @ManyToOne(optional = false)
    private Client refClient;
    @JoinColumn(name = "idDateExp", referencedColumnName = "idDate")
    @ManyToOne(optional = false)
    private Dates idDateExp;
    @JoinColumn(name = "idDate", referencedColumnName = "idDate")
    @ManyToOne(optional = false)
    private Dates idDate;

    public Commande() {
    }

    public Commande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Commande(Integer idCommande, short statut) {
        this.idCommande = idCommande;
        this.statut = statut;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public Vetement getRefVet() {
        return refVet;
    }

    public void setRefVet(Vetement refVet) {
        this.refVet = refVet;
    }

    public Client getRefClient() {
        return refClient;
    }

    public void setRefClient(Client refClient) {
        this.refClient = refClient;
    }

    public Dates getIdDateExp() {
        return idDateExp;
    }

    public void setIdDateExp(Dates idDateExp) {
        this.idDateExp = idDateExp;
    }

    public Dates getIdDate() {
        return idDate;
    }

    public void setIdDate(Dates idDate) {
        this.idDate = idDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commande.Commande[ idCommande=" + idCommande + " ]";
    }
    
}
