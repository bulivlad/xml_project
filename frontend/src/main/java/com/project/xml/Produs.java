package com.project.xml;

/**
 * Created by Costin on 12/23/2014.
 */
public class Produs {
    private String NumeProdus;
    private int pretProdus;
    private String CalitateProdus;
    private String greutateProdus;
    private String furnizor;
    private String producator;

    public Produs(String numeProdus, int pretProdus, String calitateProdus, String greutateProdus, String producator, String furnizor) {
        this.NumeProdus = numeProdus;
        this.pretProdus = pretProdus;
        this.CalitateProdus = calitateProdus;
        this.greutateProdus = greutateProdus;
        this.producator = producator;
        this.furnizor = furnizor;
    }

    public int getPretProdus() {
        return pretProdus;
    }

    public void setPretProdus(int pretProdus) {
        this.pretProdus = pretProdus;
    }

    public String getNumeProdus() {
        return NumeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        this.NumeProdus = numeProdus;
    }

    public String getCalitateProdus() {
        return CalitateProdus;
    }

    public void setCalitateProdus(String calitateProdus) {
        this.CalitateProdus = calitateProdus;
    }

    public String getFurnizor() {
        return furnizor;
    }

    public void setFurnizor(String furnizor) {
        this.furnizor = furnizor;
    }

    public String getGreutateProdus() {
        return greutateProdus;
    }

    public void setGreutateProdus(String greutateProdus) {
        this.greutateProdus = greutateProdus;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }
}
