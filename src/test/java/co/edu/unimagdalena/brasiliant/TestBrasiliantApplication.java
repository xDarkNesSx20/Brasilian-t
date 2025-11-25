package co.edu.unimagdalena.brasiliant;

import org.springframework.boot.SpringApplication;

public class TestBrasiliantApplication {

    public static void main(String[] args) {
        SpringApplication.from(BrasiliantApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
