package com.cs.idsProject.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Comune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String codiceCatasto;
    private String regione;
    private String codistat;
    private float latitudine;
    private float longitudine;

    @OneToMany(mappedBy = "comune")
    private List<POI> punti;

    @OneToMany(mappedBy = "comune")
    private List<Contest> contests;

    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodiceCatasto() {
        return codiceCatasto;
    }

    public void setCodiceCatasto(String codiceCatasto) {
        this.codiceCatasto = codiceCatasto;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getCodistat() {
        return codistat;
    }

    public void setCodistat(String codistat) {
        this.codistat = codistat;
    }

    public float getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(float latitudine) {
        this.latitudine = latitudine;
    }

    public float getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(float longitudine) {
        this.longitudine = longitudine;
    }

    public List<POI> getPunti() {
        return punti;
    }

    public void setPunti(List<POI> punti) {
        this.punti = punti;
    }

    public List<Contest> getContests() {
        return contests;
    }

    public void setContests(List<Contest> contests) {
        this.contests = contests;
    }
}
