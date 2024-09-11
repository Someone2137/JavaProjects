package Box;

public class Box implements BoxInterface {
    private final Integer length;
    private final Integer width;
    private final Integer height;
    public static Integer counter = 0;
    String contents;

    public Box(Integer length, Integer width, Integer height) throws Exception {
        if (length <= 0 || height <= 0 || width <= 0) {
            throw new CapacityError("Incorrect values of the box.");
        }
        this.length = length;
        this.width = width;
        this.height = height;
        counter++;
    }

    @Override
    public void setContents(String value, Integer capacity) throws CapacityError {
        if (capacity > getCapacity()) {
            throw new CapacityError("Content is too big.");
        }
        this.contents = value;
    }

    @Override
    public boolean isEmpty() {
        return this.contents == null || this.contents.isEmpty();
    }

    @Override
    public String getContents() throws EmptyError {
        if (isEmpty()) {
            throw new EmptyError("Box is empty.");
        }
        return this.contents;
    }

    @Override
    public Integer getCapacity() {
        return this.length * this.height * this.width;
    }

    public static Integer countAll() {
        return counter;
    }

    @Override
    public void print() throws EmptyError {
        System.out.println("Box's capacity: " + getCapacity());
        if (!isEmpty()) {
            System.out.println("Box's contents: " + getContents());
        } else {
            System.out.println("Box is empty.");
        }
    }
}
