package org.example.s34060bank;

import org.springframework.stereotype.Service;

@Service
public class TransakcjaService {
    private int clientId;
    private int saldo;

    public TransakcjaService(int clientId, int saldo) {
        this.clientId = clientId;
        this.saldo = saldo;
    }
    public void transakcja(int kwota) {
        if (saldo < kwota) {
            return;
        }
        saldo -= kwota;
    }
}
