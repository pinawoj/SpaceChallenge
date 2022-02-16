package com.paulinawojcik.spaceship;

import com.paulinawojcik.Item;

public interface SpaceShip {

    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    void carry(Item item);

}
