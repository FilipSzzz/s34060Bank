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

        bankService.zarejestrujKlienta(1, 100);
        bankService.zarejestrujKlienta(2, 200);
        bankService.wykonajPrzelew(1,200);
        bankService.wykonajPrzelew(2,100);
        System.out.println(klientStorage.getKlienci());


}
    public static void main(String[] args) {
        SpringApplication.run(S34060BankApplication.class, args);
    }

}
