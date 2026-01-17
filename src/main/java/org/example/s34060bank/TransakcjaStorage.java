package org.example.s34060bank;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransakcjaStorage {
    private List<Transakcja> transakcje = new ArrayList<>();

    public void addTransakcja(Transakcja transakcja) {
        transakcje.add(transakcja);
    }

    public List<Transakcja> getTransakcje() {
        return transakcje;
    }
}