package org.example;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class Task6 {
    public static void main(String[] args) {
        Random r = new Random();
        int size = 100;
        List<Integer> array = new ArrayList<>();
        int maxn = -1;
        int maxi = -1;
        int mean = 0;
        for (int i = 0; i < size; i++) {
            array.add(r.nextInt(1001));
            mean += array.get(i);
            if(array.get(i) > maxn){
                maxn = array.get(i);
                maxi = i;
            }
        }
        System.out.println("Максимальное значение = " + maxn +  " находится в элементе под индексом " + maxi);
        System.out.println("Среднее значение = " + mean/size);
    }
}
