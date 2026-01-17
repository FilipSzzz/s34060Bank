package org.example.s34060bank;

public class Klient {
    private int clientid;
    private int saldo;
    public Klient(int clientid, int saldo) {
        this.clientid = clientid;
        this.saldo = saldo;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getClientid() {
        return clientid;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id=" + clientid +
                ", saldo=" + saldo +
                '}';
    }
}
