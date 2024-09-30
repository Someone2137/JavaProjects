import SheepVsWolf.Sheep;
import SheepVsWolf.Wolf;
import org.junit.Assert;
import org.junit.Test;

public class WolfTest {
    Double testMovementDistance = 1.0;
    Wolf testWolf = new Wolf();
    Double fullTestValue = 1.123456;
    Double roundedTestValue = 1.123;
    Integer testSheepNumber = 2;
    Double eatenSheepXValue = 0.0;
    Double eatenSheepYValue = 0.0;
    Double chasedSheepXValue = 2.0;
    Double chasedSheepYValue = 4.0;
    Sheep eatenSheep = new Sheep(eatenSheepXValue, eatenSheepYValue, testSheepNumber);
    Sheep chasedSheep = new Sheep(chasedSheepXValue, chasedSheepYValue, testSheepNumber);

    @Test
    public void testConstructor(){
        Assert.assertEquals(Double.valueOf(0.0), testWolf.getX());
        Assert.assertEquals(Double.valueOf(0.0), testWolf.getY());
    }

    @Test
    public void roundToThirdDecimalPlaceTest(){
        Assert.assertEquals(roundedTestValue, testWolf.roundToThirdDecimalPlace(fullTestValue), 0.0001);
    }

    @Test
    public void getXTest(){
        Assert.assertEquals(Double.valueOf(0.0), testWolf.getX());
    }

    @Test
    public void getYTest(){
        Assert.assertEquals(Double.valueOf(0.0), testWolf.getY());
    }

    @Test
    public void eatSheepTest(){
        testWolf.moveToNearestSheep(eatenSheep);
        Assert.assertEquals(testWolf.getX(), eatenSheep.getX());
        Assert.assertEquals(testWolf.getY(), eatenSheep.getY());
    }

    @Test
    public void chaseSheepTest(){
        Double initialWolfXValue = testWolf.getX();
        Double initialWolfYValue = testWolf.getY();

        testWolf.moveToNearestSheep(chasedSheep);

        Double horizontalDistance = chasedSheepXValue - initialWolfXValue;
        Double verticalDistance = chasedSheepYValue - initialWolfYValue;
        Double distanceBetweenWolfAndSheep = Math.sqrt(horizontalDistance * horizontalDistance + verticalDistance * verticalDistance);

        if (distanceBetweenWolfAndSheep > 0){
            Double movementRatio = testMovementDistance / distanceBetweenWolfAndSheep;
            Double expectedWolfXValue = initialWolfXValue + horizontalDistance * movementRatio;
            Double expectedWolfYValue = initialWolfYValue + verticalDistance * movementRatio;

            expectedWolfXValue = testWolf.roundToThirdDecimalPlace(expectedWolfXValue);
            expectedWolfYValue = testWolf.roundToThirdDecimalPlace(expectedWolfYValue);

            Assert.assertEquals(expectedWolfXValue, testWolf.getX());
            Assert.assertEquals(expectedWolfYValue, testWolf.getY());
        }
    }

}
