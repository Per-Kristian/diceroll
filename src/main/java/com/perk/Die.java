package com.perk;

import java.util.Random;

public class Die {

    private Integer lastResult;

    public Integer roll() {
        this.lastResult = new Random().nextInt(1, 7);
        return lastResult;
    }

    public Integer getLastResult() {
        return lastResult;
    }
}
