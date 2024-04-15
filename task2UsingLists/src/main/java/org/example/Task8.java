package org.example;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Task8 {
    public static List<Integer> bubleSort(List<Integer> x){
        int cmp;
        for(int i = 0; i < x.size() - 1; i++) {
            for(int j = 0; j < x.size() - 1 - i; j++) {
                if(x.get(j) > x.get(j + 1)) {
                    cmp = x.get(j);
                    x.set(j, x.get(j + 1));
                    x.set(j+1, cmp);
                }
            }
        }
        return x;
    }
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("Начальный массив:");
        List<Integer> array = new ArrayList<>();
        int size = 30;
        for (int i = 0; i < size; i++) {
            array.add(r.nextInt(1000));
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
        System.out.println("Отсортированный массив:");
        array = bubleSort(array);
        for (int i: array) {
            System.out.print(array.get(i) + " ");
        }
    }
}