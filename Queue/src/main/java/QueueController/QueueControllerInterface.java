package QueueController;

public interface QueueControllerInterface {
    void popLast();
    void pushLast(Integer number);
    Integer returnFirstElement();
    Integer returnLastElement();
}
