package org.example.s34060bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BankServiceIntegrationTest {
    @MockitoBean
    private TransakcjaStorage transakcjaStorage;
    @MockitoBean
    private KlientStorage klientStorage;
    @Autowired
    private BankService bankService;

    @Test
    void testujeNormalenKorzystanie(){
        List<Klient> klienci = new ArrayList<>();
        klienci.add(new Klient(1, 100));
        klienci.add(new Klient(2, 200));
        List<Transakcja> transakcje = new ArrayList<>();
        transakcje.add(new Transakcja(Status.ACCEPTED, 50, 1));
        transakcje.add(new Transakcja(Status.ACCEPTED, 100, 2));

        when(klientStorage.getKlienci()).thenReturn(klienci);
        when(transakcjaStorage.getTransakcje()).thenReturn(transakcje);
        bankService.wykonajPrzelew(1, 50);
        bankService.wykonajPrzelew(2, 150);

        assertEquals(50, bankService.znajdzKlienta(1).getSaldo());
        assertEquals(50, bankService.znajdzKlienta(2).getSaldo());
    }
    @Test
    void testujePrzelewNieMozliwyGdyzNieMaKlienta(){
        bankService.wykonajPrzelew(1, 100);
        assertEquals(true, bankService.znajdzKlienta(1) == null);
    }
//    @Test
//    void testujePrzelewNieMozliwyGdyzKlientNieMaSalda(){
//        bankService.zarejestrujKlienta(1, 100);
//        bankService.wykonajPrzelew(1, 200);
//        when(klientStorage.getKlienci()).thenReturn(new ArrayList<>());
//        when(bankService.znajdzKlienta(1).getSaldo()).thenReturn(0);
//        when(transakcjaStorage.getTransakcje()).thenReturn(new ArrayList<>());
//        bankService.wykonajPrzelew(1, 200);
//    }
    @Test
    void czyDaSieBezRejestracji(){
        bankService.wykonajPrzelew(1, 200);
        assertEquals(bankService.znajdzKlienta(1) == null, true);
    }


}
