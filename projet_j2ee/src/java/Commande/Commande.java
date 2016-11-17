/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import Client.Client;
import Dates.Dates;
import Vente.Vente;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Val Gros Pénis
 */
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c order by c.idCommande DESC"),
    @NamedQuery(name = "Commande.findByIdCommande", query = "SELECT c FROM Commande c WHERE c.idCommande = :idCommande"),
    @NamedQuery(name = "Commande.findByStatut", query = "SELECT c FROM Commande c WHERE c.statut = :statut"),
    @NamedQuery(name = "Commande.findByPrixC", query = "SELECT c FROM Commande c WHERE c.prixC = :prixC")})
public class Commande implements Serializable, Cloneable {
@Basic(optional = false)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixC")
    private float prixC;
    @JoinColumn(name = "refClient", referencedColumnName = "refClient")
    @ManyToOne(optional = false)
    private Client refClient;
    @JoinColumn(name = "idDateExp", referencedColumnName = "idDate")
    @ManyToOne
    private Dates idDateExp;
    @JoinColumn(name = "idDate", referencedColumnName = "idDate")
    @ManyToOne(optional = false)
    private Dates idDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCommande")
    private List<Vente> venteList;

    public Commande() {
        Random r = new Random();
        this.idCommande = r.nextInt(9999999);
    }

    public Commande(Integer idCommande) {
        this.idCommande = idCommande;
    }
    
    public Commande(Integer idCommande, short statut) {
        this.idCommande = idCommande;
        this.statut = statut;
    }

    public Commande(Integer idCommande, short statut, int prixC) {
        this.idCommande = idCommande;
        this.statut = statut;
        this.prixC = prixC;
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

    public float getPrixC() {
        return prixC;
    }

    public void setPrixC(float prixC) {
        this.prixC = prixC;
    }

    public Client getClient() {
        return refClient;
    }

    public void setClient(Client refClient) {
        this.refClient = refClient;
    }

    public Dates getDateExp() {
        return idDateExp;
    }

    public void setDateExp(Dates idDateExp) {
        this.idDateExp = idDateExp;
    }

    public Dates getDate() {
        return idDate;
    }

    public void setDate(Dates idDate) {
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
        return !((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande)));
    }

    @Override
    public String toString() {
        return "Commande.Commande[ idCommande=" + idCommande + " ]";
    }
    
    @XmlTransient
    public List<Vente> getVenteList() {
        return venteList;
    }

    public void setVenteList(List<Vente> venteList) {
        this.venteList = venteList;
    }
    
    public String getStringStatut() {
        return (statut == 0) ? "en attente" : "envoyée";
    }
    
    public boolean mayBeRendered() {
        return (statut == 0);
    }
    
    @Override
    public Commande clone() {
        try {
                Object c = super.clone();
                return (Commande) c;
        } catch(CloneNotSupportedException cnse) {
                cnse.printStackTrace(System.err);
        }
        return null;
    }
}
