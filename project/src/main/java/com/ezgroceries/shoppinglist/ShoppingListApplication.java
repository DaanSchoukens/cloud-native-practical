package com.ezgroceries.shoppinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ezgroceries.shoppinglist")
public class ShoppingListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingListApplication.class, args);
    }

}
