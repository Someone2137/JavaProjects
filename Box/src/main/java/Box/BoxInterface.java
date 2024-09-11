package Box;

public interface BoxInterface {
    void print() throws EmptyError;

    String getContents() throws EmptyError;

    void setContents(String value, Integer capacity) throws CapacityError;

    Integer getCapacity();

    static Integer countAll() {
        return null;
    }

    boolean isEmpty();
}
