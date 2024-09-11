import Box.Box;
import Box.EmptyError;
import Box.CapacityError;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BoxTest {
    Box testBox;
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
    public void testGetCapacity() throws Exception {
        testBox = new Box(testValue, secondTestValue, thirdTestValue);
        Assert.assertEquals(capacity, testBox.getCapacity());
    }

    @Test
    public void boxTestWithValidDimensions() throws Exception {
        testBox = new Box(testValue, secondTestValue, thirdTestValue);
        Assert.assertNotNull(testBox);
        Assert.assertEquals(capacity, testBox.getCapacity());
    }

    @Test
    public void boxTestWithInvalidDimensions(){
        Assert.assertThrows(EmptyError.class, () -> new Box(fourthTestValue, fifthTestValue, sixthTestValue));
    }

    @Test
    public void setContentsTestWithValidCapacity() throws Exception {
        testBox = new Box(testValue, secondTestValue, thirdTestValue);
        testBox.setContents(value, validValueCapacity);
        Assert.assertEquals(value, testBox.getContents());
    }

    @Test
    public void setContentsTestWithInvalidCapacity(){
        Assert.assertThrows(CapacityError.class, () -> new Box(thirdTestValue, fourthTestValue, fifthTestValue));

    }

    @Test
    public void testGetContents() throws Exception {
        testBox = new Box(testValue, secondTestValue, thirdTestValue);
        testBox.setContents(value, validValueCapacity);
        Assert.assertEquals(value, testBox.getContents());
    }

    @Test
    public void testGetContentsWhenEmpty() throws Exception {
        testBox = new Box(testValue, secondTestValue, thirdTestValue);
        Assert.assertThrows(EmptyError.class, () -> testBox.getContents());
    }

    @Test
    public void testIsEmpty() throws Exception {
        testBox = new Box(testValue, secondTestValue, thirdTestValue);
        Assert.assertTrue(testBox.isEmpty());

        testBox.setContents(value, validValueCapacity);
        Assert.assertFalse(testBox.isEmpty());
    }

    @Before
    public void setUpForCountAll() {
        Box.counter = 0;
    }

    @Test
    public void testCountAllInitially() {
        Integer actualCount = Box.countAll();

        Assert.assertEquals(Integer.valueOf(0), actualCount);
    }

    @Test
    public void testCountAllAfterCreatingBoxes() throws Exception {
        testBox = new Box(testValue, secondTestValue, thirdTestValue);
        testBox = new Box(testValue, secondTestValue, thirdTestValue);

        Integer actualCount = Box.countAll();

        Assert.assertEquals(Integer.valueOf(2), actualCount);
    }

    @Before
    public void setUpForPrint(){
        originalOutput = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testPrintWhenNotEmpty() throws Exception {
        testBox = new Box(testValue, secondTestValue, thirdTestValue);
        testBox.setContents(value,validValueCapacity);

        testBox.print();
        String expectedOutput = "Box's capacity: 24\r\nBox's contents: chair\r\n";
        String actualOutput = outputStream.toString();

        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testPrintWhenEmpty() throws Exception {
        testBox = new Box(testValue, secondTestValue, thirdTestValue);

        testBox.print();
        String expectedOutput = "Box's capacity: 24\r\nBox is empty.\r\n";
        String actualOutput = outputStream.toString();

        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @After
    public void tearDown() {
        System.setOut(originalOutput);
    }

}
