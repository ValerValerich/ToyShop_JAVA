package org.example;

import java.util.UUID;

public class Toys {
    UUID id;
    String nomenklature;
    int frequency;

    public Toys(UUID id, String nomenklature, int frequency) {
        this.id = id;
        this.nomenklature = nomenklature;
        this.frequency = frequency;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomenklature() {
        return nomenklature;
    }

    public void setNomenklature(String nomenklature) {
        this.nomenklature = nomenklature;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Toys{" +
                "id=" + id +
                ", nomenklature='" + nomenklature + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
