package com.cs.idsProject.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preferito")
public class Preferito {

    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Integer IDutente;

    @ManyToOne
    @JoinColumn(name = "id_contenuto", nullable = false)
    private Contenuto contenuto;


    public Preferito() {
    }

    public Preferito(Integer IDutente, Contenuto contenuto) {
        this.IDutente = IDutente;
        this.contenuto = contenuto;
    }

    public Integer getIDutente() {
        return IDutente;
    }

    public void setIDutente(Integer IDutente) {
        this.IDutente = IDutente;
    }

    public Contenuto getContenuto() {
        return contenuto;
    }

    public void setContenuto(Contenuto contenuto) {
        this.contenuto = contenuto;
    }
}
