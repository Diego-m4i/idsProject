package com.cs.idsProject.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Comune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String codiceCatasto;
    private String regione;
    private String codistat;
    private float latitudine;
    private float longitudine;
    private List<Contest> contest;
    private List<POI> punti;

    public Comune(int id, String nome, String codiceCatasto, String regione, String codistat, float latitudine, float longitudine, List<POI> punti, List<Contest> contest) {
        this.id = id;
        this.nome = nome;
        this.codiceCatasto = codiceCatasto;
        this.regione = regione;
        this.codistat = codistat;
        this.latitudine = latitudine;
        this.longitudine = longitudine;

        this.punti = new ArrayList<>(); // Inizializza la lista dei punti di interesse.
        this.contest = new ArrayList<>(); // Inizializza la lista dei contest.

    }


    public Integer getId() {
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

    public void setContest(List<Contest> contest) {
        this.contest = contest;
    }


    public List<POI> getPoints(){
        return punti; // Restituisce la lista dei punti di interesse associati alla città.
    }

    public POI getPoint(Integer id) {
        for(POI point: this.punti) {
            if(point.getId().equals(id)) return point; // Restituisce il punto di interesse con l'ID specificato.
        }
        return null; // Se non viene trovato nessun punto di interesse con l'ID specificato, restituisce null.
    }

    public void addPoint(POI point) {
        this.punti.add(point); // Aggiunge un punto di interesse alla lista dei punti di interesse associati alla città.
    }

    public void removePoint(Integer id) {
        this.punti.removeIf(p -> p.getId().equals(id)); // Rimuove un punto di interesse dalla lista dei punti di interesse associati alla città.
    }



    public List<Contest> getContest(){
        return contest; // Restituisce la lista dei contest associati alla città.
    }

    public void addContest(Contest contest){
        this.contest.add(contest); // Aggiunge un contest alla lista dei contest associati alla città.
    }

    public void removeContest(Integer id) {
        this.contest.removeIf(c -> c.getId().equals(id)); // Rimuove un contest dalla lista dei contest associati alla città.
    }

    public Contest getContest(Integer id){
        for(Contest contest: this.contest) {
            if(contest.getId().equals(id)) return contest; // Restituisce il contest con l'ID specificato.
        }
        return null; // Se non viene trovato nessun contest con l'ID specificato, restituisce null.
    }

    public void addContent(Contenuto content, Integer pointId){
        this.punti.get(pointId).addContent(content); // Aggiunge un contenuto a un punto di interesse specifico.
    }

    public void removeContent(Integer contentId, Integer pointId){
        this.punti.get(pointId).removeContent(contentId); // Rimuove un contenuto da un punto di interesse specifico.
    }

    public Contenuto getContent(Integer contentId, Integer pointId){
        return this.getPoint(pointId).getContenuti(contentId); // Restituisce un contenuto da un punto di interesse specifico.
    }

}
