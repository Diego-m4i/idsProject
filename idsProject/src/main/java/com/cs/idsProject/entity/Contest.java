package com.cs.idsProject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comune;
    private String titolo;
    private String descrizione;
    private boolean pubblico;
    private Integer idAnimatore;
    private Integer idVincitore;
    private String dataScadenza;

    @OneToMany(mappedBy = "contest")
    private List<Contenuto> contenuti;

    public Contest(Integer id, String comune, String titolo, String descrizione, boolean pubblico, Integer idAnimatore, Integer idVincitore, String dataScadenza, List<Contenuto> contenuti) {
        this.id = id;
        this.comune = comune;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.pubblico = pubblico;
        this.idAnimatore = idAnimatore;
        this.idVincitore = idVincitore;
        this.dataScadenza = dataScadenza;
        this.contenuti = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isPubblico() {
        return pubblico;
    }

    public void setPubblico(boolean pubblico) {
        this.pubblico = pubblico;
    }

    public Integer getIdAnimatore() {
        return idAnimatore;
    }

    public void setIdAnimatore(Integer idAnimatore) {
        this.idAnimatore = idAnimatore;
    }

    public Integer getIdVincitore() {
        return idVincitore;
    }

    public void setIdVincitore(Integer idVincitore) {
        this.idVincitore = idVincitore;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }

    public void addContent(Contenuto content){
        this.contenuti.add(content);
    }

    public void removeContent(Contenuto content) {
        this.contenuti.remove(content);
    }

}
