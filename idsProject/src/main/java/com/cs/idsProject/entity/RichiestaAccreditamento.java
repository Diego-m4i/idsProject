package com.cs.idsProject.entity;

import org.apache.catalina.util.Introspection;

import javax.persistence.*;

@Entity
public class RichiestaAccreditamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRuolo;
    private Integer idUtente;

    @Enumerated(EnumType.STRING)
    private StatoRichiesta stato;

    public int getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(int idRuolo) {
        this.idRuolo = idRuolo;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public StatoRichiesta getStato() {
        return stato;
    }

    public void setStato(StatoRichiesta stato) {
        this.stato = stato;
    }
}
