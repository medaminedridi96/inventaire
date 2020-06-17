package com.dridimedamine.entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agent {



    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("nom")
    @Expose
    private String nom;

    @SerializedName("prenom")
    @Expose
    private String prenom;

    @SerializedName("adresse")
    @Expose
    private String adresse;

    @SerializedName("tel")
    @Expose
    private Integer tel;


    public Agent() {
    }

    public Agent(Integer id, String nom, String prenom, String adresse, Integer tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }


    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel=" + tel +
                '}';
    }
}
