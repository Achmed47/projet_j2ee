/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

/**
 *
 * @author léa
 */
public class DataChart {
    private String type;
    private int mois;
    private int nbVentes;

    public DataChart(int nbVentes, String type, int mois) {
        this.type = type;
        this.mois = mois;
        this.nbVentes = nbVentes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getNbVentes() {
        return nbVentes;
    }

    public void setNbVentes(int nbVentes) {
        this.nbVentes = nbVentes;
    }

    @Override
    public String toString() {
        return "DataChart{" + "type=" + type + ", mois=" + mois + ", nbVentes=" + nbVentes + '}';
    }
}
