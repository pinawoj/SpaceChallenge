package com.paulinawojcik.spaceship;

import java.util.ArrayList;

public class U1 extends Rocket {

    public U1() {

        this.cost = 100;
        this.weight = 10 * 1000;
        this.maxWeight = 18 * 1000;
        this.carriedItems = new ArrayList<>();

    }

    @Override
    public boolean launch() {

        double explosionChance = 0.05 * ((double) weight / maxWeight);
        return (explosionChance < Math.random()) ? true : false;

    }

    @Override
    public boolean land() {

        double crashChance = 0.01 * ((double) weight / maxWeight);
        return (crashChance < Math.random()) ? true : false;

    }

}
