package org.example.s34060bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BankServiceIntegrationTest {
    @MockitoBean
    private TransakcjaStorage transakcjaStorage;
    @MockitoBean
    private KlientStorage klientStorage;
    @Autowired
    private BankService bankService;

    @Test
    void testujeCzyMoznaToSamoID(){
        List<Klient> klienci = new ArrayList<>();
        klienci.add(new Klient(1, 100));
        List<Transakcja> transakcje = new ArrayList<>();
        transakcje.add(new Transakcja(Status.ACCEPTED, 50, 1));

        klienci.add(new Klient(1, 100));


    }
}
