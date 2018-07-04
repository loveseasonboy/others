package com.simple;

public class sageer implements Mume {
    private Mume mume;

    public sageer(Mume mume) {
        this.mume=mume;
    }

    @Override
    public int cost() {
        return mume.cost() + 3;
    }
}
