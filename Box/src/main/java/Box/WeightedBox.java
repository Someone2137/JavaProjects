package Box;

public class WeightedBox extends Box implements WeightedBoxInterface {
    private final Integer maxWeight;

    public WeightedBox(Integer length, Integer width, Integer height, Integer maxWeight) throws Exception {
        super(length, width, height);

        if (maxWeight <= 0) {
            throw new CapacityError("Incorrect maximal weight of the box.");
        }

        this.maxWeight = maxWeight;
    }

    @Override
    public void setContents(String value, Integer capacity, Integer weight) throws Exception {
        if (capacity > getCapacity()) {
            throw new CapacityError("Content is too big.");
        }

        if (weight > maxWeight) {
            throw new WeightError("Content is too heavy.");
        }

        this.contents = value;
    }

    @Override
    public void print() throws EmptyError {
        System.out.println("The box's maximum weight equals: " + maxWeight);
        super.print();
    }
}
