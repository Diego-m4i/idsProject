package com.cs.idsProject.entity;

public enum StatoRichiesta {
    APPROVATA("APPROVATA"),
    RIFIUTATA("RIFIUTATA"),
    PENDING("PENDING");
    private final String status;

    StatoRichiesta(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    }

