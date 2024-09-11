package Box;

public class ColouredBox extends Box implements ColouredBoxInterface {
    private final Integer colour;

    public ColouredBox(Integer length, Integer width, Integer height, Integer colour) throws Exception {
        super(length, width, height);
        this.colour = colour;
    }

    @Override
    public void print() throws EmptyError {
        System.out.println("The box has this colour: " + Integer.toHexString(colour));
        super.print();
    }
}
