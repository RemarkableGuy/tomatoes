package com.relay42.tomatoes.services;

import com.relay42.tomatoes.domain.TomatoSale;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;

@Service
public class TomatoSaleService {

    private static final int MAX = 1000;
    private static final int MIN = 1;
    private static final String BEGIN = "2018-01-01 00:00:00";

    public ArrayList<TomatoSale> getSales(int size) {
        Random rand = new Random();
        ArrayList<TomatoSale> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(new TomatoSale(UUID.randomUUID(), rand.nextInt(MAX - MIN + 1) + MIN, "Alvaro", this.getRandomTimestamp()));
        }

        list.sort(Collections.reverseOrder());
        return list;
    }

    private long getRandomTimestamp() {
        Random rand = new Random();

        long begin = Timestamp.valueOf(BEGIN).getTime();
        long end = System.currentTimeMillis();
        long diff = end - begin + 1;

        return (long) (begin + rand.nextDouble() * diff);
    }
}
