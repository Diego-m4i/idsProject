package com.cs.idsProject.entity;

import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String sesso;
    private String luogoNascita;
    private String email;

    private List<Preferito> favorites;
private List<Ruolo> ruolo;

    public Utente(Integer id, String username, String password, String sesso, String luogoNascita, String email ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sesso = sesso;
        this.luogoNascita = luogoNascita;
        this.email = email;
        this.favorites = new ArrayList<>();
        this.ruolo = new ArrayList<>();

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public List<Ruolo> getRuolo() {
        return ruolo;
    }

    public void addRuolo(Ruolo ruolo) {
        this.ruolo.add(ruolo);
    }
    public void addFavorite(Preferito favorite){
        this.favorites.add(favorite);
    }


}