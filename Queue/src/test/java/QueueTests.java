import Queue.Queue;
import org.junit.Assert;
import org.junit.Test;

public class QueueTests {
    Queue testQueue = new Queue();
    Integer testValue = 1;

    @Test
    public void pushTest() {
        Assert.assertEquals(testQueue.getTheQueue().size(), 0);

        testQueue.push(testValue);
        Assert.assertEquals(testQueue.getTheQueue().size(), 1);

        Assert.assertEquals(testQueue.getTheQueue().getFirst(), testValue);
    }

    @Test
    public void shouldThrowExceptionWhenQueueIsEmpty() {
        Assert.assertEquals(testQueue.getTheQueue().size(), 0);
        Assert.assertThrows(Exception.class, () -> testQueue.pop());
    }

    @Test
    public void ShouldPopWhenQueueIsNotEmpty(){
        testQueue.push(testValue);
        Assert.assertNotEquals(testQueue.getTheQueue().size(), 0);

        try {
            testQueue.pop();
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertEquals(testQueue.getTheQueue().size(), 0);
    }
}
