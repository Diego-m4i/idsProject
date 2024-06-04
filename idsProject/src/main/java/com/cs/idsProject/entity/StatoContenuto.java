package com.cs.idsProject.entity;

public enum StatoContenuto {

        Pending("Pending"),
        Rifiutato("Rifiutato"),
        Pubblicato("Pubblicato"),
        Bozza("Bozza");

        private final String status;

    StatoContenuto(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }

