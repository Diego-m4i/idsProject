package com.cs.idsProject.entity;

public enum StatoContenuto {

        Pending("Pending"),
        Published("Rifiutato"),
        Rejected("Pubblicato"),
        Draft("Bozza");

        private final String status;

    StatoContenuto(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }

