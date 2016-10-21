/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sabat
 */
@Embeddable
public class StockPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    private int refVet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    private String taille;

    public StockPK() {
    }

    public StockPK(int refVet, String taille) {
        this.refVet = refVet;
        this.taille = taille;
    }

    public int getRefVet() {
        return refVet;
    }

    public void setRefVet(int refVet) {
        this.refVet = refVet;
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
        hash += (int) refVet;
        hash += (taille != null ? taille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockPK)) {
            return false;
        }
        StockPK other = (StockPK) object;
        if (this.refVet != other.refVet) {
            return false;
        }
        if ((this.taille == null && other.taille != null) || (this.taille != null && !this.taille.equals(other.taille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.StockPK[ refVet=" + refVet + ", taille=" + taille + " ]";
    }
    
}
