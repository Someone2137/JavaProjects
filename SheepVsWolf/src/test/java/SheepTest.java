import SheepVsWolf.Sheep;
import org.junit.Assert;
import org.junit.Test;

public class SheepTest {
    Integer testSheepNumber = 2;
    Double testXValue = 2.0;
    Double testYValue = 4.0;
    Double testMovementDistance = 0.5;
    Sheep testSheep = new Sheep(testXValue, testYValue, testSheepNumber);

    @Test
    public void getXTest(){
        Assert.assertEquals(testXValue, testSheep.getX());
    }

    @Test
    public void getYTest(){
        Assert.assertEquals(testYValue, testSheep.getY());
    }

    @Test
    public void getSheepNumberTest() {
        Assert.assertEquals(testSheepNumber, testSheep.getSheepNumber());
    }

    @Test
    public void testMove() {
        Double initialXValue = testSheep.getX();
        Double initialYValue = testSheep.getY();

        testSheep.move();
        Double newXValue = testSheep.getX();
        Double newYValue = testSheep.getY();

        Assert.assertTrue(Math.abs(newXValue - initialXValue) == testMovementDistance || Math.abs(newYValue - initialYValue) == testMovementDistance);
    }


}
