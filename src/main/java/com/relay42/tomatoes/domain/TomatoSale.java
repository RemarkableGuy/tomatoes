package com.relay42.tomatoes.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TomatoSale implements Comparable<TomatoSale> {

    private final UUID id;
    private final int tomatoes;
    private final String provider;
    private final long timestamp;

    public TomatoSale(UUID id, int tomatoes, String provider, long timestamp) {
        this.id = id;
        this.tomatoes = tomatoes;
        this.provider = provider;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(TomatoSale tomatoSale) {
        return Long.compare(this.getTimestamp(), tomatoSale.getTimestamp());
    }
}
