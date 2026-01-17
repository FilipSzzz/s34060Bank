package org.example.s34060bank;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class KlientStorage {
    private List<Klient> klienci = new ArrayList<>();

    public List<Klient> getKlienci() {
        return klienci;
    }
    public void addKlient(Klient klient) {
        klienci.add(klient);
    }
}