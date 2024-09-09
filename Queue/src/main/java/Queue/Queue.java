package Queue;

import java.util.ArrayList;

public class Queue implements QueueInterface {

    private final ArrayList<Integer> theQueue = new ArrayList<>();

    @Override
    public void push(Integer number) {
        this.theQueue.addLast(number);
    }

    @Override
    public void pop() throws Exception {
        if (this.theQueue.size() <= 0) {
            throw new Exception("Queue is empty.");
        }
        this.theQueue.removeLast();
    }

    public ArrayList<Integer> getTheQueue() {
        return theQueue;
    }
}
