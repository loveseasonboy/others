package com.simple;

public class milk implements Mume {
    private Mume mume;

    public milk(Mume mume) {
        this.mume = mume;
    }

    @Override
    public int cost() {
        return mume.cost()+10;
    }
}
