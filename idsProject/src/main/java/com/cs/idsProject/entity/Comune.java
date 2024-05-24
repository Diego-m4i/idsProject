package com.cs.idsProject.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // Indica che questa classe è un'entità JPA e deve essere mappata su una tabella nel database.
@Table(name = "Comune") // Specifica il nome della tabella nel database.
public class Comune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Identificatore univoco della città nel database.

    @Column(unique = true) // Specifica che il valore di questa colonna deve essere univoco.
    private String cadastralCode; // Codice catastale della città.

    private String name; // Nome della città.
    private String region; // Regione in cui si trova la città.
    private Integer istatCode; // Codice ISTAT della città.
    private float longitude; // Longitudine della posizione della città.
    private float latitude; // Latitudine della posizione della città.

    // Relazione uno-a-molti con Contest: una città può avere più contest.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cityId") // Nome della colonna che fa riferimento all'ID della città nella tabella dei contest.
    private List<Contest> contests; // Lista dei contest associati alla città.

    // Relazione uno-a-molti con Point: una città può avere più punti di interesse.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cityId") // Nome della colonna che fa riferimento all'ID della città nella tabella dei punti di interesse.
    private List<POI> points; // Lista dei punti di interesse associati alla città.

    // Costruttore che inizializza una città con i parametri forniti.
    public Comune(String cadastralCode, String name, String region, Integer istatCode, float longitude, float latitude) {
        this.cadastralCode = cadastralCode;
        this.name = name;
        this.region = region;
        this.istatCode = istatCode;
        this.longitude = longitude;
        this.latitude = latitude;
        this.points = new ArrayList<>(); // Inizializza la lista dei punti di interesse.
        this.contests = new ArrayList<>(); // Inizializza la lista dei contest.
    }

    // Costruttore vuoto necessario per JPA.
    public Comune() { }

    // Metodi getter e setter per gli attributi della città.

    public Integer getId() {
        return id; // Restituisce l'ID della città.
    }

    public String getCadastralCode() {
        return cadastralCode; // Restituisce il codice catastale della città.
    }

    public void setCadastralCode(String cadastralCode) {
        this.cadastralCode = cadastralCode; // Imposta il codice catastale della città.
    }

    public String getName() {
        return name; // Restituisce il nome della città.
    }

    public void setName(String name) {
        this.name = name; // Imposta il nome della città.
    }

    public String getRegion() {
        return region; // Restituisce la regione della città.
    }

    public void setRegion(String region) {
        this.region = region; // Imposta la regione della città.
    }

    public Integer getIstatCode() {
        return istatCode; // Restituisce il codice ISTAT della città.
    }

    public void setIstatCode(Integer istatCode) {
        this.istatCode = istatCode; // Imposta il codice ISTAT della città.
    }

    public float getLatitude() {
        return latitude; // Restituisce la latitudine della città.
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude; // Imposta la latitudine della città.
    }

    public float getLongitude() {
        return longitude; // Restituisce la longitudine della città.
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude; // Imposta la longitudine della città.
    }

    public List<Contest> getContests(){
        return contests; // Restituisce la lista dei contest associati alla città.
    }

    public void addContest(Contest contest){
        this.contests.add(contest); // Aggiunge un contest alla lista dei contest associati alla città.
    }

    public void removeContest(Integer id) {
        this.contests.removeIf(c -> c.getId().equals(id)); // Rimuove un contest dalla lista dei contest associati alla città.
    }

    public Contest getContest(Integer id){
        for(Contest contest: this.contests) {
            if(contest.getId().equals(id)) return contest; // Restituisce il contest con l'ID specificato.
        }
        return null; // Se non viene trovato nessun contest con l'ID specificato, restituisce null.
    }

    public List<POI> getPoints(){
        return points; // Restituisce la lista dei punti di interesse associati alla città.
    }

    public void addPoint(POI point) {
        this.points.add(point); // Aggiunge un punto di interesse alla lista dei punti di interesse associati alla città.
    }

    public void removePoint(Integer id) {
        this.points.removeIf(p -> p.getId().equals(id)); // Rimuove un punto di interesse dalla lista dei punti di interesse associati alla città.
    }

    public POI getPoint(Integer id) {
        for(POI point: this.points) {
            if(point.getId().equals(id)) return point; // Restituisce il punto di interesse con l'ID specificato.
        }
        return null; // Se non viene trovato nessun punto di interesse con l'ID specificato, restituisce null.
    }

    public void addContent(Content content, Integer pointId){
        this.points.get(pointId).addContent(content); // Aggiunge un contenuto a un punto di interesse specifico.
    }

    public void removeContent(Integer contentId, Integer pointId){
        this.points.get(pointId).removeContent(contentId); // Rimuove un contenuto da un punto di interesse specifico.
    }

    public Content getContent(Integer contentId, Integer pointId){
        return this.getPoint(pointId).getContent(contentId); // Restituisce un contenuto da un punto di interesse specifico.
    }

}
