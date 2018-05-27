package com.relay42.tomatoes.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class TomatoSale implements Comparable<TomatoSale> {

    private final UUID id;
    private final int tomatoes;
    private final String provider;
    private final long timestamp;

    @Override
    public int compareTo(TomatoSale tomatoSale) {
        return Long.compare(this.getTimestamp(), tomatoSale.getTimestamp());
    }
}
