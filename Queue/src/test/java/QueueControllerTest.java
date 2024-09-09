import QueueController.QueueController;
import org.junit.Assert;
import org.junit.Test;

public class QueueControllerTest {

    QueueController testQueueController = new QueueController();
    Integer testValue = 1;
    Integer secondTestValue = 2;

    @Test
    public void popLastTest() {
        try {
            testQueueController.popLast();
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void pushLastTest() {
        testQueueController.pushLast(testValue);
        testQueueController.pushLast(secondTestValue);
        Assert.assertEquals(testQueueController.returnLastElement(), secondTestValue);
    }

    @Test
    public void returnFirstElementTest() {
        testQueueController.pushLast(testValue);
        testQueueController.pushLast(secondTestValue);
        Assert.assertEquals(testQueueController.returnFirstElement(), testValue);
    }

    @Test
    public void returnLastElementTest() {
        testQueueController.pushLast(testValue);
        testQueueController.pushLast(secondTestValue);
        Assert.assertEquals(testQueueController.returnLastElement(), secondTestValue);
    }
}
