package com.dridimedamine.entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Produit {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("nom")
    @Expose
    private String nom;

    @SerializedName("quantite")
    @Expose
    private Integer quantite;

    public Produit() {
    }

    public Produit(Integer id, String nom, Integer quantite) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom=" + nom +
                ", quantite=" + quantite +
                '}';
    }
}
