package org.example.s34060bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S34060BankApplication {
    private final KlientStorage klientStorage;
    private final TransakcjaStorage transakcjaStorage;
    private final BankService bankService;
    public S34060BankApplication(KlientStorage klientStorage, TransakcjaStorage transakcjaStorage, BankService bankService) {
        this.klientStorage = klientStorage;
        this.transakcjaStorage = transakcjaStorage;
        this.bankService = bankService;

        bankService.zarejestrujKlienta(1, 1000);
        bankService.wplac(1, 100);
        bankService.wykonajPrzelew(1, 50);
        System.out.println(bankService.znajdzKlienta(1).getSaldo());

}
    public static void main(String[] args) {
        SpringApplication.run(S34060BankApplication.class, args);
    }

}
