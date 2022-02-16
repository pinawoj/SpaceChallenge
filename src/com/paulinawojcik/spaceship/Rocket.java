package com.paulinawojcik.spaceship;

import com.paulinawojcik.Item;

import java.util.List;

public class Rocket implements SpaceShip {

    protected int cost;
    protected int weight;
    protected int maxWeight;
    protected List<Item> carriedItems;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {

        return (weight + item.getWeight() <= maxWeight) ? true : false;
    }

    @Override
    public void carry(Item item) {

        weight += item.getWeight();
        carriedItems.add(item);

    }

    public int getCost() {
        return cost;
    }

    public List<Item> getCarriedItems() {
        return carriedItems;
    }

}
