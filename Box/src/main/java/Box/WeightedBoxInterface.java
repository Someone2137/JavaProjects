package Box;

public interface WeightedBoxInterface {
    void setContents(String value, Integer capacity, Integer weight) throws Exception;

    void print() throws EmptyError;
}
