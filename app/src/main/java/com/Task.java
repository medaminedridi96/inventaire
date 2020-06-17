package com;

public class Task {
    private int id;
    private String ville ;
    private String action;

    public Task(int id, String ville, String action) {
        this.id = id;
        this.ville = ville;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
