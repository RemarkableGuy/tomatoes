package com.relay42.tomatoes.services;

import com.relay42.tomatoes.domain.TomatoSale;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class TomatoSaleService {

    private static final int MAX = 1000;
    private static final int MIN = 1;
    private static final String BEGIN = "2018-01-01 00:00:00";

    private String[] providers = {"Heinz", "Hunt's", "Del Monte", "Le Ol' Granma"};

    public List<TomatoSale> getSales(int size) {
        Random random = new Random();
        List<TomatoSale> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new TomatoSale(UUID.randomUUID(), random.nextInt(MAX - MIN + 1) + MIN, this.providers[random.nextInt(this.providers.length)], this.getRandomTimestamp()));
        }
        list.sort(Collections.reverseOrder());
        return list;
    }

    private long getRandomTimestamp() {
        Random random = new Random();
        long begin = Timestamp.valueOf(BEGIN).getTime();
        long end = System.currentTimeMillis();
        long diff = end - begin + 1;
        return (long) (begin + random.nextDouble() * diff);
    }
}
