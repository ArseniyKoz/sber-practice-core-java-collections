package org.example;

import com.sun.jdi.connect.spi.TransportService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) {
        Map<Long, String> phoneBook = new LinkedHashMap<>();

        phoneBook.put(89217255054L, "Сидоров Агафон Никанорович");
        phoneBook.put(89535720971L, "Петров Петр Петрович");
        phoneBook.put(89113315675L, "Иванов Иван Иванович");


        //  Random
        Map<Long, String> randomBook = new HashMap<>();
        for (Map.Entry<Long, String> entry : phoneBook.entrySet()) {
            randomBook.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Long, String> entry : randomBook.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println();

        //  Sorted by key
        Map<Long, String> sortedPhoneBook = new LinkedHashMap<>();
        phoneBook.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> sortedPhoneBook.put(x.getKey(), x.getValue()));

        for (Map.Entry<Long, String> entry : sortedPhoneBook.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println();

        // FIFO
        Map<Long, String> orderBook = new LinkedHashMap<>(phoneBook);

        for (Long key : orderBook.keySet()) {
            System.out.println(key + " " + phoneBook.get(key));
        }

        System.out.println();

        //  sorted by value
        Map<Long, String> sortedValuePhoneBook = new LinkedHashMap<>();
        phoneBook.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedValuePhoneBook.put(x.getKey(), x.getValue()));

        for (Map.Entry<Long, String> entry : sortedValuePhoneBook.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
