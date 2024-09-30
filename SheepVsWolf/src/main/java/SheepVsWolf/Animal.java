package SheepVsWolf;

public class Animal implements AnimalInterface {
    Double x;
    Double y;

    public Animal(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Double distanceBetweenAnimals(Animal other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}
