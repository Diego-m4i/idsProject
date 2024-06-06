package com.cs.idsProject.entity;

import javax.persistence.*;
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
    private int idAnimatore;
    private String dataScadenza;

    @OneToMany(mappedBy = "contest")
    private List<Contenuto> contenuti;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getIdAnimatore() {
        return idAnimatore;
    }

    public void setIdAnimatore(int idAnimatore) {
        this.idAnimatore = idAnimatore;
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
}
