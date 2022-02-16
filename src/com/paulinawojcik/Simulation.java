package com.paulinawojcik;

import com.paulinawojcik.spaceship.Rocket;
import com.paulinawojcik.spaceship.U1;
import com.paulinawojcik.spaceship.U2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Simulation {

    public List<Item> loadItems(String path) {

        List<Item> itemList = new ArrayList<>();

        try {

            File file = new File(path);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();

                Item item = new Item();
                item.setName(line.split("=")[0]);
                item.setWeight(Integer.parseInt(line.split("=")[1]));
                itemList.add(item);

            }

            fileScanner.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
            System.exit(0);

        }

        return itemList;
    }

    public List<Rocket> loadU1(List<Item> itemList) {

        List<Rocket> u1RocketList = new ArrayList<>();

        while (!itemList.isEmpty()) {

            U1 u1Rocket = new U1();

            Iterator<Item> iItemList = itemList.iterator();
            while (iItemList.hasNext()) {
                Item item = iItemList.next();
                if (u1Rocket.canCarry(item)) {
                    u1Rocket.carry(item);
                    iItemList.remove();
                } else {
                    break;
                }
            }

            u1RocketList.add(u1Rocket);
        }

        return u1RocketList;
    }

    public List<Rocket> loadU2(List<Item> itemList) {

        List<Rocket> u2RocketList = new ArrayList<>();

        while (!itemList.isEmpty()) {

            U2 u2Rocket = new U2();

            Iterator<Item> iItemList = itemList.iterator();
            while (iItemList.hasNext()) {
                Item item = iItemList.next();
                if (u2Rocket.canCarry(item)) {
                    u2Rocket.carry(item);
                    iItemList.remove();
                } else {
                    break;
                }
            }

            u2RocketList.add(u2Rocket);
        }

        return u2RocketList;
    }

    public int runSimulation(List<Rocket> rocketList) {

        int budget = 0;

        while (!rocketList.isEmpty()) {

            Iterator<Rocket> iRocketList = rocketList.iterator();
            while (iRocketList.hasNext()) {

                Rocket rocket = iRocketList.next();
                if (rocket.launch() && rocket.land()) {
                    iRocketList.remove();
                } else {
                    System.out.println("One of " + rocket.getClass().getSimpleName() + " rockets crashed!");
                }

                budget += rocket.getCost();
            }

        }

        return budget;
    }

}
