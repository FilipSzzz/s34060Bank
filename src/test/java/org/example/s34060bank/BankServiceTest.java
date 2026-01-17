package org.example.s34060bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {
    private BankService bankService;
    private KlientStorage klientStorage;
    private TransakcjaStorage transakcjaStorage;
    @BeforeEach
    void setUp() {
        this.transakcjaStorage = new TransakcjaStorage();
        this.klientStorage = new KlientStorage();
        this.bankService = new BankService(klientStorage, transakcjaStorage);
    }
    @Test
    void depositMoney(){
        bankService.zarejestrujKlienta(1, 100);
        bankService.wplac(1, 50);
        assertEquals(150, bankService.znajdzKlienta(1).getSaldo());
    }
    @Test
    void zaMaloKasyByPrzelac(){
        bankService.zarejestrujKlienta(1, 100);
        bankService.wykonajPrzelew(1,111);
        assertEquals(100, bankService.znajdzKlienta(1).getSaldo());
    }
    @Test
    void czyDodanyDoBazy(){
        bankService.zarejestrujKlienta(1, 100);
        assertEquals(1, klientStorage.getKlienci().size());
    }
    @Test
    void czyDodanaTransakcja(){
        bankService.zarejestrujKlienta(1, 100);
        bankService.wplac(1, 50);
        assertEquals(1, transakcjaStorage.getTransakcje().size());
    }
    @Test
    void czyNieZnalezionoKlienta(){
        assertEquals(Status.NIE_ZNALEZIONO_CLIENTA, bankService.wykonajPrzelew(1, 100));
    }
    @Test
    void czyNieDodanoDoBazyGdyzNieZarejestrowano(){
        bankService.wykonajPrzelew(1, 100);
        assertEquals(0, klientStorage.getKlienci().size());
    }
    @Test
    void przelew(){
        bankService.zarejestrujKlienta(1, 100);
        bankService.wykonajPrzelew(1, 50);
        assertEquals(50, bankService.znajdzKlienta(1).getSaldo());
    }

}
