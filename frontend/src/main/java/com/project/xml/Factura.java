package com.project.xml;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Costin on 12/23/2014.
 */
public class Factura {

    private String data;
    private int pretTotal;
    private String modDePlate;
    private String numeAngajat;
    private String prenumeangajat;
    private String functieangajat;
    private int varstaAngajat;
    private ArrayList<Produs> produse = new  ArrayList<Produs>();
    private int numarProduse;

    public Factura(String data, int pretTotal, String modDePlate, String numeAngajat, String prenumeangajat, String functieangajat, int varstaAngajat, ArrayList<Produs> produse, int numarProduse) {
        this.data = data;
        this.pretTotal = pretTotal;
        this.modDePlate = modDePlate;
        this.numeAngajat = numeAngajat;
        this.prenumeangajat = prenumeangajat;
        this.functieangajat = functieangajat;
        this.varstaAngajat = varstaAngajat;
        for(int i=0;i<produse.size();i++)
            this.produse.add(produse.get(i));
        this.numarProduse = numarProduse;
    }

    public int getNumarProduse() {
        return numarProduse;
    }

    public void setNumarProduse(int numarProduse) {
        this.numarProduse = numarProduse;
    }

    public Factura(String data, int pretTotal, String modDePlate, String numeAngajat, String prenumeangajat, String functieangajat, int varstaAngajat, ArrayList<Produs> produse) {
        this.data = data;
        this.pretTotal = pretTotal;
        this.modDePlate = modDePlate;
        this.numeAngajat = numeAngajat;
        this.prenumeangajat = prenumeangajat;
        this.functieangajat = functieangajat;
        this.varstaAngajat = varstaAngajat;
        this.produse = produse;
    }

    public int getPretTotal() {
        return pretTotal;
    }

    public void setPretTotal(int pretTotal) {
        this.pretTotal = pretTotal;
    }

    public String getModDePlate() {
        return modDePlate;
    }

    public void setModDePlate(String modDePlate) {
        this.modDePlate = modDePlate;
    }

    public String getNumeAngajat() {
        return numeAngajat;
    }

    public void setNumeAngajat(String numeAngajat) {
        this.numeAngajat = numeAngajat;
    }

    public String getPrenumeangajat() {
        return prenumeangajat;
    }

    public void setPrenumeangajat(String prenumeangajat) {
        this.prenumeangajat = prenumeangajat;
    }

    public String getFunctieangajat() {
        return functieangajat;
    }

    public void setFunctieangajat(String functieangajat) {
        this.functieangajat = functieangajat;
    }

    public int getVarstaAngajat() {
        return varstaAngajat;
    }

    public void setVarstaAngajat(int varstaAngajat) {
        this.varstaAngajat = varstaAngajat;
    }

    public ArrayList<Produs> getProduse() {
        return produse;
    }

    public void setProduse(ArrayList<Produs> produse) {
        this.produse = produse;
    }

    public Factura(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

