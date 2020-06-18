package com.dridimedamine.entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Depot {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("adresse")
    @Expose
    private String adresse;

    @SerializedName("action")
    @Expose
    private String action;

    @SerializedName("produits")

    List<Produit> produit= new ArrayList<Produit>();


    public Depot() {
    }

    public Depot(Integer id, String adresse, String action, List<Produit> produit) {
        this.id = id;
        this.adresse = adresse;
        this.action = action;
        this.produit = produit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
        return "Depot numero" +
                 id
                 ;
    }
}
