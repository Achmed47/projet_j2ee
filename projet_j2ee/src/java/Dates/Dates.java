/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dates;

import Commande.Commande;
import java.io.Serializable;
import java.util.Collection;
import java.util.Random;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sabat
 */
@Entity
@Table(name = "dates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dates.findAll", query = "SELECT d FROM Dates d"),
    @NamedQuery(name = "Dates.findByIdDate", query = "SELECT d FROM Dates d WHERE d.idDate = :idDate"),
    @NamedQuery(name = "Dates.findByMinute", query = "SELECT d FROM Dates d WHERE d.minute = :minute"),
    @NamedQuery(name = "Dates.findByHeure", query = "SELECT d FROM Dates d WHERE d.heure = :heure"),
    @NamedQuery(name = "Dates.findByJour", query = "SELECT d FROM Dates d WHERE d.jour = :jour"),
    @NamedQuery(name = "Dates.findByMois", query = "SELECT d FROM Dates d WHERE d.mois = :mois"),
    @NamedQuery(name = "Dates.findByAnnee", query = "SELECT d FROM Dates d WHERE d.annee = :annee")})
public class Dates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDate")
    private Integer idDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "minute")
    private int minute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heure")
    private int heure;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jour")
    private int jour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mois")
    private int mois;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annee")
    private int annee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDateExp")
    private Collection<Commande> commandeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDate")
    private Collection<Commande> commandeCollection1;

    public Dates() {
        Random r = new Random();
        this.idDate = r.nextInt(9999999);
    }

    public Dates(Integer idDate) {
        this.idDate = idDate;
    }

    public Dates(Integer idDate, int minute, int heure, int jour, int mois, int annee) {
        this.idDate = idDate;
        this.minute = minute;
        this.heure = heure;
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public Integer getIdDate() {
        return idDate;
    }

    public void setIdDate(Integer idDate) {
        this.idDate = idDate;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection1() {
        return commandeCollection1;
    }

    public void setCommandeCollection1(Collection<Commande> commandeCollection1) {
        this.commandeCollection1 = commandeCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDate != null ? idDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dates)) {
            return false;
        }
        Dates other = (Dates) object;
        if ((this.idDate == null && other.idDate != null) || (this.idDate != null && !this.idDate.equals(other.idDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return jour + "/" + mois + "/" + annee + " " + heure + ":" + minute;
    }
    
}
