package org.example.s34060bank;

public class Transakcja {
    private Status status;
    private int kwota;
    private int clientId;

    public Transakcja(Status status, int kwota, int clientId) {
        this.status = status;
        this.kwota = kwota;
        this.clientId = clientId;
    }

    public Status getStatus() {
        return status;
    }

    public int getKwota() {
        return kwota;
    }

    public int getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return "Transakcja{" +
                "status=" + status +
                ", kwota=" + kwota +
                ", clientId=" + clientId +
                '}';
    }
}
