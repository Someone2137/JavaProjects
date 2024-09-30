import SheepVsWolf.Animal;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    Double testXValue = 2.0;
    Double testYValue = 4.0;
    Double testSecondXValue = 4.0;
    Double testSecondYValue = 6.0;
    Animal testAnimal = new Animal(testXValue, testYValue);
    Animal secondTestAnimal = new Animal(testSecondXValue, testSecondYValue);

    @Test
    public void distanceBetweenAnimalsTest() {
        Assert.assertEquals(Double.valueOf(2.8284271247461903), testAnimal.distanceBetweenAnimals(secondTestAnimal));
    }
}
