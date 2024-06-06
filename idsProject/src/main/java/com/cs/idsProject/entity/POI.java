package com.cs.idsProject.entity;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
public class POI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descrizione;
    private float longitudine;
    private float latitudine;

    private float altitudine;
    private Integer idComune;

    @OneToMany(mappedBy = "punto")
    private List<Contenuto> contenuti;

  /*  @ManyToOne
    @JoinColumn(name = "comune_id")
    private Comune comune;
*/

    public POI(Integer id, String nome, String descrizione, float longitudine, float latitudine, float altitudine, List<Contenuto> contenuti, Integer idComune) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.longitudine = longitudine;
        this.latitudine = latitudine;
        this.altitudine = altitudine;
        this.contenuti = new ArrayList<>();
        this.idComune = idComune;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public float getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(float longitudine) {
        this.longitudine = longitudine;
    }

    public float getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(float latitudine) {
        this.latitudine = latitudine;
    }

    public float getAltitudine() {
        return altitudine;
    }

    public void setAltitudine(float altitudine) {
        this.altitudine = altitudine;
    }

    public Integer getIdComune() {
        return idComune;
    }

    public void setIdComune(Integer idComune) {
        this.idComune = idComune;
    }

    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }

    public Contenuto getContenuti(Integer contentId) {
        return null;
    }

    public void addContent(Contenuto content) {
    }

    public void removeContent(Integer contentId) {
    }
}
