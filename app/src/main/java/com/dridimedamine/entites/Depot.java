package com.dridimedamine.entites;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Depot implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("adresse")
    private String address;

    @SerializedName("action")
    private String action;

    @SerializedName("produits")
    List<Produit> produit = new ArrayList<Produit>();


    public Depot() {

    }

    public Depot(int id, String address, String action, List<Produit> produit) {
        this.id = id;
        this.address = address;
        this.action = action;
        this.produit = produit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Produit> getProduit() {
        return produit;
    }

    public void setProduit(List<Produit> produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Dépôt N° " + getId();
    }
}
