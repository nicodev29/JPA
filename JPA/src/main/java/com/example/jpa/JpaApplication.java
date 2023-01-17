package com.example.jpa;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class JpaApplication {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.ejecucion();

    }
}
