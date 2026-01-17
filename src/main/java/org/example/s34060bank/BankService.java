package org.example.s34060bank;

import org.springframework.stereotype.Service;

@Service
public class BankService {
    private final KlientStorage klientStorage;
    private final TransakcjaStorage transakcjaStorage;

    public BankService(KlientStorage klientStorage, TransakcjaStorage transakcjaStorage) {
        this.klientStorage = klientStorage;
        this.transakcjaStorage = transakcjaStorage;
    }

    public void zarejestrujKlienta(int id, int saldo) {
        if (znajdzKlienta(id) != null) {
            System.out.println("nie mozna o tym samy idclienta");
            return;
        }
        klientStorage.addKlient(new Klient(id, saldo));
    }
    public Klient znajdzKlienta(int id) {
        for (Klient klient : klientStorage.getKlienci()) {
            if (klient.getClientid() == id) {
                return klient;
            }
        }
        return null;
    }
    public void wplac(int id, int kwota) {
        Klient klient = znajdzKlienta(id);
        if (klient != null) {
            klient.setSaldo(klient.getSaldo() + kwota);
            transakcjaStorage.addTransakcja(new Transakcja(Status.ACCEPTED, kwota, id));
        }
    }

    public Status wykonajPrzelew(int id, int kwota) {
        Klient nadawca = znajdzKlienta(id);
        if (nadawca == null) {
            return Status.NIE_ZNALEZIONO_CLIENTA;
        }
        if (nadawca.getSaldo() < kwota) {
            transakcjaStorage.addTransakcja(new Transakcja(Status.DECLINED, kwota, id));
            return Status.DECLINED;
        }
        nadawca.setSaldo(nadawca.getSaldo() - kwota);
        transakcjaStorage.addTransakcja(new Transakcja(Status.ACCEPTED, kwota, id));
        return Status.ACCEPTED;
    }

}
