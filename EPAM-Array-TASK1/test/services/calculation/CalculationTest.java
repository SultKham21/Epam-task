package services.calculation;

import array.entity.CustomArray;
import array.exception.CustomArrayException;
import array.services.calculation.Calculation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CalculationTest {
    CustomArray arrayForTest;
    Calculation calculationForArrayTest;

    @BeforeClass
    public void serUp() throws CustomArrayException {
        arrayForTest = new CustomArray(-1, 2, 5);
        calculationForArrayTest = new Calculation();
    }

    @Test
    public void testSumOfElementsArray() throws CustomArrayException {
        int actual = calculationForArrayTest.calculateSum(arrayForTest);
        assertEquals(actual,6);
    }

    @Test
    public void tesNumOfNegativeElements() throws CustomArrayException {
        int actual = calculationForArrayTest.calculateNumberOfNegative(arrayForTest);
        assertEquals(actual,1);
    }

    @Test
    public void testNumOfPositiveElements() throws CustomArrayException {
        int actual = calculationForArrayTest.calculateNumberOfPositive(arrayForTest);
        assertEquals(actual,2);
    }

    @Test
    public void testAcerageValueCalculate() throws CustomArrayException {
        double actual = calculationForArrayTest.calculateAverageValue(arrayForTest);
        assertEquals(actual,(double) 2);
    }

    @Test
    public void tesNumOfPositiveElements(){
        int actual = calculationForArrayTest.calculateSumOfElementStream(arrayForTest);
        assertEquals(actual,6);
    }
}
