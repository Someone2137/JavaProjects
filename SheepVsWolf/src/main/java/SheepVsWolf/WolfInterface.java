package SheepVsWolf;

public interface WolfInterface {
    Double roundToThirdDecimalPlace(Double value);

    public Double getX();

    public Double getY();

    void moveToNearestSheep(Sheep nearestSheep);
}
