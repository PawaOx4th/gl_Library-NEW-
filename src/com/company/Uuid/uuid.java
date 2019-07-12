package com.company.Uuid;
import java.util.UUID;

public class uuid {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            System.out.println("Random UUID String = "+i +"  :"+ randomUUIDString);
        }
    }
}
