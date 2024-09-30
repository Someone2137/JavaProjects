package SheepVsWolf;

import java.util.Random;

public class Sheep extends Animal implements  SheepInterface{
    private final Random randomMovement = new Random();
    private final Integer sheepNumber;

    public Sheep(Double x, Double y, Integer sheepNumber) {
        super(x, y);
        this.sheepNumber = sheepNumber;
    }

    @Override
    public Double getX() {
        return this.x;
    }

    @Override
    public Double getY() {
        return this.y;
    }

    @Override
    public Integer getSheepNumber() {
        return this.sheepNumber;
    }

    @Override
    public void move() {
        int direction = this.randomMovement.nextInt(4);
        double movementDistance = 0.5;

        switch (direction) {
            case 0:
                this.x += movementDistance;
                break;
            case 1:
                this.x -= movementDistance;
                break;
            case 2:
                this.y += movementDistance;
                break;
            case 3:
                this.y -= movementDistance;
                break;
        }
    }
}
