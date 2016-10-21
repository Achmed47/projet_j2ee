/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

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
import Commande.Commande;

/**
 *
 * @author sabat
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByRefClient", query = "SELECT c FROM Client c WHERE c.refClient = :refClient"),
    @NamedQuery(name = "Client.findByMail", query = "SELECT c FROM Client c WHERE c.mail = :mail"),
    @NamedQuery(name = "Client.findByMotDePasse", query = "SELECT c FROM Client c WHERE c.motDePasse = :motDePasse"),
    @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom"),
    @NamedQuery(name = "Client.findByNumeroRue", query = "SELECT c FROM Client c WHERE c.numeroRue = :numeroRue"),
    @NamedQuery(name = "Client.findByRue", query = "SELECT c FROM Client c WHERE c.rue = :rue"),
    @NamedQuery(name = "Client.findByComplementAdresse", query = "SELECT c FROM Client c WHERE c.complementAdresse = :complementAdresse"),
    @NamedQuery(name = "Client.findByCodePostal", query = "SELECT c FROM Client c WHERE c.codePostal = :codePostal"),
    @NamedQuery(name = "Client.findByVille", query = "SELECT c FROM Client c WHERE c.ville = :ville")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "refClient")
    private Integer refClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "motDePasse")
    private String motDePasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroRue")
    private int numeroRue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "rue")
    private String rue;
    @Size(max = 255)
    @Column(name = "complementAdresse")
    private String complementAdresse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codePostal")
    private int codePostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ville")
    private String ville;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refClient")
    private Collection<Commande> commandeCollection;

    public Client() {
    }

    public Client(Integer refClient) {
        this.refClient = refClient;
    }

    public Client(Integer refClient, String mail, String motDePasse, String prenom, String nom, int numeroRue, String rue, int codePostal, String ville) {
        this.refClient = refClient;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.prenom = prenom;
        this.nom = nom;
        this.numeroRue = numeroRue;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Integer getRefClient() {
        return refClient;
    }

    public void setRefClient(Integer refClient) {
        this.refClient = refClient;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refClient != null ? refClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.refClient == null && other.refClient != null) || (this.refClient != null && !this.refClient.equals(other.refClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Client[ refClient=" + refClient + " ]";
    }
    
}
