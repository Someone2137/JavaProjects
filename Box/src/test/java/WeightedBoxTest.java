import Box.Box;
import Box.CapacityError;
import Box.EmptyError;
import Box.WeightError;
import Box.WeightedBox;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WeightedBoxTest {
    WeightedBox testBox;
    Integer validWeightValue = 25;
    Integer invalidWeightValue = 40;
    Integer validMaxWeightTestValue = 30;
    Integer invalidMaxWeightTestValue = 0;
    Integer testValue = 2;
    Integer secondTestValue = 3;
    Integer thirdTestValue = 4;
    Integer fourthTestValue = 0;
    Integer fifthTestValue = 0;
    Integer sixthTestValue = 0;
    String value = "chair";
    Integer validValueCapacity = 20;
    Integer invalidValueCapacity = 100;
    Integer capacity = testValue * secondTestValue * thirdTestValue;
    ByteArrayOutputStream outputStream;
    PrintStream originalOutput;

    @Test
    public void weightedBoxTestWithValidDimensions() throws Exception {
        testBox = new WeightedBox(testValue, secondTestValue, thirdTestValue, validMaxWeightTestValue);
        Assert.assertNotNull(testBox);
        Assert.assertEquals(capacity, testBox.getCapacity());

    }

    @Test
    public void weightedBoxTestWithInvalidDimensions() throws Exception {
        Assert.assertThrows(CapacityError.class, () -> new WeightedBox(fourthTestValue, fifthTestValue, sixthTestValue, invalidMaxWeightTestValue));


    }

    @Test
    public void setContentsTestWithValidCapacityAndWeight() throws Exception {
        testBox = new WeightedBox(testValue, secondTestValue, thirdTestValue, validMaxWeightTestValue);
        testBox.setContents(value, validValueCapacity, validWeightValue);
        Assert.assertEquals(value, testBox.getContents());
    }

    @Test
    public void setContentsTestWithInvalidCapacity() throws Exception {
        testBox = new WeightedBox(testValue, secondTestValue, thirdTestValue, validMaxWeightTestValue);
        Assert.assertThrows(CapacityError.class, () -> testBox.setContents(value, invalidValueCapacity, validWeightValue));
    }

    @Test
    public void setContentsTestWithInvalidWeight() throws Exception {
        testBox = new WeightedBox(testValue, secondTestValue, thirdTestValue, validMaxWeightTestValue);
        Assert.assertThrows(WeightError.class, () -> testBox.setContents(value, validValueCapacity, invalidWeightValue));
    }

    @Before
    public void setUpForPrint(){
        originalOutput = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void printTestWhenNotEmpty() throws Exception {
        testBox = new WeightedBox(testValue, secondTestValue, thirdTestValue, validMaxWeightTestValue);
        testBox.setContents(value, validValueCapacity, validWeightValue);
        testBox.print();

        String expectedOutput = "The box's maximum weight equals: 30\r\nBox's capacity: 24\r\nBox's contents: chair\r\n";
        String actualOutput = outputStream.toString();
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void printTestWhenEmpty() throws Exception {
        testBox = new WeightedBox(testValue, secondTestValue, thirdTestValue, validMaxWeightTestValue);
        testBox.print();

        String expectedOutput = "The box's maximum weight equals: 30\r\nBox's capacity: 24\r\nBox is empty.\r\n";
        String actualOutput = outputStream.toString();
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @After
    public void tearDown() {
        System.setOut(originalOutput);
    }
}
