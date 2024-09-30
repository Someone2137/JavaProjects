package SheepVsWolf;

import java.util.ArrayList;
import java.util.Random;

public class Simulation implements SimulationInterface {
    private static final Double sheepPositionLimit = 10.0;
    private final ArrayList<Sheep> sheepList;
    private final Wolf wolf;
    private Integer currentRoundNumber = 0;
    private int numberOfSheep = 15;

    public Simulation() {
        this.sheepList = new ArrayList<>();
        this.wolf = new Wolf();


        Random randomSheepPosition = new Random();
        for (int index = 0; index < this.numberOfSheep; index++) {
            Double x = (randomSheepPosition.nextDouble() * 2 * sheepPositionLimit) - sheepPositionLimit;
            Double y = (randomSheepPosition.nextDouble() * 2 * sheepPositionLimit) - sheepPositionLimit;
            sheepList.add(new Sheep(x, y, index + 1));
        }
    }

    @Override
    public void runSimulation() {
        Integer numberOfRounds = 50;
        while (currentRoundNumber < numberOfRounds && !sheepList.isEmpty()) {
            currentRoundNumber++;
            for (Sheep sheep : sheepList) {
                sheep.move();
            }
            Sheep closestSheep = null;
            Double minDistance = Double.MAX_VALUE;
            for (Sheep sheep : sheepList) {
                Double distanceBetweenSheepAndWolf = wolf.distanceBetweenAnimals(sheep);
                if (distanceBetweenSheepAndWolf < minDistance) {
                    minDistance = distanceBetweenSheepAndWolf;
                    closestSheep = sheep;
                }
            }

            if (closestSheep != null) {
                if (minDistance < wolf.movementDistance) {
                    System.out.println("Round: " + currentRoundNumber + ". Wolf eats sheep number: " + closestSheep.getSheepNumber());
                    sheepList.remove(closestSheep);
                    this.numberOfSheep--;
                    wolf.moveToNearestSheep(closestSheep);
                } else {
                    System.out.println("Round: " + currentRoundNumber + ". Wolf is chasing sheep number: " + closestSheep.getSheepNumber());
                    wolf.moveToNearestSheep(closestSheep);
                }
            }

            System.out.println("Round: " + currentRoundNumber + ". Wolf's position: (" + wolf.getX() + " : " + wolf.getY() + ")");
            System.out.println("Round: " + currentRoundNumber + ". " + sheepList.size() + " sheep remaining.");
            System.out.println();
        }

        if (sheepList.isEmpty()) {
            System.out.println("All sheep have been eaten.");
        } else {
            System.out.println("Maximum number of round has been reached.");
        }
    }

}
