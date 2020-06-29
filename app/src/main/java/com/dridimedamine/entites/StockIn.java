package com.dridimedamine.entites;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockIn {
    @SerializedName("id")
    private int id;

    @SerializedName("date")
    private Date date;

    @SerializedName("action")
    private String action;

    @SerializedName("agent")
    List<Agent> agent = new ArrayList<Agent>();

    @SerializedName("depot")
    List<Depot> depot = new ArrayList<Depot>();

    public StockIn(int id, Date date, String action, List<Agent> agent, List<Depot> depot) {
        this.id = id;
        this.date = date;
        this.action = action;
        this.agent = agent;
        this.depot = depot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Agent> getAgent() {
        return agent;
    }

    public void setAgent(List<Agent> agent) {
        this.agent = agent;
    }

    public List<Depot> getDepot() {
        return depot;
    }

    public void setDepot(List<Depot> depot) {
        this.depot = depot;
    }

    @Override
    public String toString() {
        return "StockIn{" +
                "id=" + id +
                ", date=" + date +
                ", action='" + action + '\'' +
                ", agent=" + agent +
                ", depot=" + depot +
                '}';
    }
}
