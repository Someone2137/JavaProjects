import Box.ColouredBox;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ColouredBoxTest {
    ColouredBox testBox;
    Integer testValue = 2;
    Integer secondTestValue = 3;
    Integer thirdTestValue = 4;
    String value = "chair";
    Integer validValueCapacity = 20;
    Integer colourTestValue = 0xffff00;
    ByteArrayOutputStream outputStream;
    PrintStream originalOutput;

    @Before
    public void setUpForPrint(){
        originalOutput = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testPrintWhenNotEmpty() throws Exception {
        testBox = new Box.ColouredBox(testValue, secondTestValue, thirdTestValue, colourTestValue);
        testBox.setContents(value,validValueCapacity);
        testBox.print();

        String expectedOutput = "The box has this colour: ffff00\r\nBox's capacity: 24\r\nBox's contents: chair\r\n";
        String actualOutput = outputStream.toString();

        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testPrintWhenEmpty() throws Exception {
        testBox = new Box.ColouredBox(testValue, secondTestValue, thirdTestValue, colourTestValue);
        testBox.getCapacity();
        testBox.print();

        String expectedOutput = "The box has this colour: ffff00\r\nBox's capacity: 24\r\nBox is empty.\r\n";
        String actualOutput = outputStream.toString();

        Assert.assertEquals(expectedOutput,actualOutput);
    }
}
