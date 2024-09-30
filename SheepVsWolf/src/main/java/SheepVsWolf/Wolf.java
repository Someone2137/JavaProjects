package SheepVsWolf;

public class Wolf extends Animal implements WolfInterface {
    final Double movementDistance = 1.0;

    public Wolf() {
        super(0.0, 0.0);
    }

    @Override
    public Double roundToThirdDecimalPlace(Double value) {
        return (double) Math.round(value * 1000) / 1000;
    }

    @Override
    public Double getX() {
        return roundToThirdDecimalPlace(x);
    }

    @Override
    public Double getY() {
        return roundToThirdDecimalPlace(y);
    }

    @Override
    public void moveToNearestSheep(Sheep nearestSheep) {
        Double distance = distanceBetweenAnimals(nearestSheep);

        if (distance < movementDistance) {
            this.x = nearestSheep.x;
            this.y = nearestSheep.y;
        } else {
            Double horizontalDistance = nearestSheep.x - this.x;
            Double verticalDistance = nearestSheep.y - this.y;
            Double distanceBetweenWolfAndSheep = Math.sqrt(horizontalDistance * horizontalDistance + verticalDistance * verticalDistance);
            this.x += (horizontalDistance / distanceBetweenWolfAndSheep) * movementDistance;
            this.y += (verticalDistance / distanceBetweenWolfAndSheep) * movementDistance;
        }
    }
}
