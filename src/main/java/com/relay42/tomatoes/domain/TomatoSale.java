package com.relay42.tomatoes.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TomatoSale implements Comparable<TomatoSale> {

    private UUID id;
    private int tomatoes;
    private String provider;
    private long timestamp;

    @Override
    public int compareTo(TomatoSale tomatoSale) {
        return Long.compare(this.getTimestamp(), tomatoSale.getTimestamp());
    }
}
