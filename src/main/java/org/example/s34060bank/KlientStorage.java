package org.example.s34060bank;

import java.util.ArrayList;

public class KlientStorage {
    private ArrayList<Klient> klienci = new ArrayList<>();
    public KlientStorage() {}
    public ArrayList<Klient> getKlienci() {
        return new ArrayList<>();
    }
    public void addKlient(Klient klient) {
        klienci.add(klient);
    }



}
