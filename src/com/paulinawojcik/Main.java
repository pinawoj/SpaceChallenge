package com.paulinawojcik;

import com.paulinawojcik.spaceship.Rocket;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        String[] rockets = {"U1", "U2"};

        for (String rocket : rockets) {
            System.out.println("\nSimulation for " + rocket);
            System.out.println("[ Phase 1 ]");
            startSimulation(simulation, "phase-1.txt", rocket);
            System.out.println("[ Phase 2 ]");
            startSimulation(simulation, "phase-2.txt", rocket);
        }

    }

    static void startSimulation(Simulation simulation, String path, String rocket) {

        List<Item> itemList = simulation.loadItems(path);
        List<Rocket> rocketList;

        if (rocket.equals("U1")) {
            rocketList = simulation.loadU1(itemList);
        } else if (rocket.equals("U2")) {
            rocketList = simulation.loadU2(itemList);
        } else {
            System.out.println("Incorrect rocket!");
            return;
        }

        int budget = simulation.runSimulation(rocketList);
        System.out.println("Operation cost: $" + budget + " Million");

    }

}
