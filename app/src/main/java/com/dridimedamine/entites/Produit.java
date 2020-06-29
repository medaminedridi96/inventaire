package com.dridimedamine.entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Produit implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("nom")
    private String nom;

    @SerializedName("quantite")
    private int quantite;

    @SerializedName("code")
    private String code;

    public Produit() {
    }

    public Produit(int id, String nom, int quantite, String code) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.code= code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getCode() { return  code; }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom=" + nom +
                ", quantite=" + quantite +
                "code=" + code+
                '}';
    }
}
