import QueueController.QueueController;

public class ProgrammeInstance {

    public static void main(String[] args) {
        QueueController queue = new QueueController();

        queue.pushLast(1);
        queue.pushLast(2);
        System.out.println("First element: " + queue.returnFirstElement());
        System.out.println("Last element: " + queue.returnLastElement());
        queue.popLast();
        System.out.println("Last element: " + queue.returnLastElement());
    }
}
