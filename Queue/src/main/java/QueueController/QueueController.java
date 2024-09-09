package QueueController;

import Queue.Queue;

public class QueueController implements QueueControllerInterface {

    private final Queue queue = new Queue();

    @Override
    public void popLast() {
        try {
            this.queue.pop();
        } catch (Exception e) {
            System.out.println("Queue is empty.");
        }
    }

    @Override
    public void pushLast(Integer number) {
        this.queue.push(number);
    }

    @Override
    public Integer returnFirstElement() {
        return this.queue.getTheQueue().getFirst();
    }

    @Override
    public Integer returnLastElement() {
        return this.queue.getTheQueue().getLast();
    }
}
