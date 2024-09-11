package Box;

public class ProgrammeInstance {
    public static void main(String[] args) throws Exception {
        try {
            Box firstBox = new Box(2, 5, 3);
            firstBox.setContents("chair", 10);
            System.out.println(firstBox.getContents());
            firstBox.print();
        } catch (EmptyError | CapacityError e) {
            System.out.println(e.getMessage());
        }

        try {
            ColouredBox secondBox = new ColouredBox(2, 5, 4, 0xffff00);
            secondBox.print();
        } catch (CapacityError | EmptyError e) {
            System.out.println(e.getMessage());
        }

        try {
            WeightedBox thirdBox = new WeightedBox(2, 5, 5, 30);
            thirdBox.setContents("books", 20, 25);
            System.out.println(thirdBox.getContents());
            thirdBox.print();
        } catch (CapacityError | EmptyError | WeightError e) {
            System.out.println(e.getMessage());
        }
        System.out.println("This many boxes have been created: " + Box.countAll());
    }
}
