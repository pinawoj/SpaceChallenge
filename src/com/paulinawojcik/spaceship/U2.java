package com.paulinawojcik.spaceship;

import java.util.ArrayList;

public class U2 extends Rocket {

    public U2() {

        this.cost = 120;
        this.weight = 18 * 1000;
        this.maxWeight = 29 * 1000;
        this.carriedItems = new ArrayList<>();

    }

    @Override
    public boolean launch() {

        double explosionChance = 0.04 * ((double) weight / maxWeight);
        return (explosionChance < Math.random()) ? true : false;

    }

    @Override
    public boolean land() {

        double crashChance = 0.08 * ((double) weight / maxWeight);
        return (crashChance < Math.random()) ? true : false;

    }

}
