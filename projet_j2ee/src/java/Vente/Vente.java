/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import Commande.Commande;
import Couleurs.Couleurs;
import Motif.Motif;
import Tailles.Tailles;
import Vetement.Vetement;
import java.io.Serializable;
import java.util.Random;
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
@Table(name = "vente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vente.findAll", query = "SELECT v FROM Vente v"),
    @NamedQuery(name = "Vente.findByPositionMotif", query = "SELECT v FROM Vente v WHERE v.positionMotif = :positionMotif"),
    @NamedQuery(name = "Vente.findByQuantite", query = "SELECT v FROM Vente v WHERE v.quantite = :quantite"),
    @NamedQuery(name = "Vente.findByIdVente", query = "SELECT v FROM Vente v WHERE v.idVente = :idVente"),
    @NamedQuery(name = "Vente.findByPrixV", query = "SELECT v FROM Vente v WHERE v.prixV = :prixV"),
    @NamedQuery(name = "Vente.findByFaceVetement", query = "SELECT v FROM Vente v WHERE v.faceVetement = :faceVetement")})
public class Vente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "positionMotif")
    private short positionMotif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantite")
    private int quantite;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVente")
    private Integer idVente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixV")
    private float prixV;
    @Basic(optional = false)
    @NotNull
    @Column(name = "faceVetement")
    private boolean faceVetement;
    @JoinColumn(name = "idCommande", referencedColumnName = "idCommande")
    @ManyToOne(optional = false)
    private Commande idCommande;
    @JoinColumn(name = "idCouleur", referencedColumnName = "idCouleur")
    @ManyToOne(optional = false)
    private Couleurs idCouleur;
    @JoinColumn(name = "idMotif", referencedColumnName = "idMotif")
    @ManyToOne(optional = false)
    private Motif idMotif;
    @JoinColumn(name = "idTaille", referencedColumnName = "idTaille")
    @ManyToOne(optional = false)
    private Tailles idTaille;
    @JoinColumn(name = "refVet", referencedColumnName = "refVet")
    @ManyToOne(optional = false)
    private Vetement refVet;

    public Vente() {
        Random randomGenerator = new Random();
        this.idVente = randomGenerator.nextInt(9999999);
        this.faceVetement = true; 
    }

    public Vente(Integer idVente) {
        this.idVente = idVente;
        this.faceVetement = true;
    }
    
    public Vente(Couleurs couleur) {
        this.idCouleur = couleur;
        this.faceVetement = true;
    }

    public Vente(Integer idVente, short positionMotif, int quantite, float prixV, boolean faceVetement) {
        this.idVente = idVente;
        this.positionMotif = positionMotif;
        this.quantite = quantite;
        this.prixV = prixV;
        this.faceVetement = faceVetement;
    }

    public short getPositionMotif() {
        return positionMotif;
    }

    public void setPositionMotif(short positionMotif) {
        this.positionMotif = positionMotif;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Integer getIdVente() {
        return idVente;
    }

    public void setIdVente(Integer idVente) {
        this.idVente = idVente;
    }

    public float getPrixV() {
        return prixV;
    }

    public void setPrixV(float prixV) {
        this.prixV = prixV;
    }

    public boolean getFaceVetement() {
        return faceVetement;
    }
    
    public String getFaceVetementAsString() {
        return faceVetement ? "avant" : "arriere";
    }

    public void setFaceVetement(boolean faceVetement) {
        this.faceVetement = faceVetement;
    }

    public Commande getCommande() {
        return idCommande;
    }

    public void setCommande(Commande idCommande) {
        this.idCommande = idCommande;
    }

    public Couleurs getCouleur() {
        return idCouleur;
    }

    public void setCouleur(Couleurs idCouleur) {
        this.idCouleur = idCouleur;
    }

    public Motif getMotif() {
        return idMotif;
    }

    public void setMotif(Motif idMotif) {
        this.idMotif = idMotif;
    }

    public Tailles getTaille() {
        return idTaille;
    }

    public void setTaille(Tailles idTaille) {
        this.idTaille = idTaille;
    }

    public Vetement getVet() {
        return refVet;
    }

    public void setVet(Vetement refVet) {
        this.refVet = refVet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVente != null ? idVente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vente)) {
            return false;
        }
        Vente other = (Vente) object;
        if ((this.idVente == null && other.idVente != null) || (this.idVente != null && !this.idVente.equals(other.idVente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vente.Vente[ idVente=" + idVente + " ]";
    }
    
}
