package services.sort;

import array.entity.CustomArray;
import array.exception.CustomArrayException;
import array.services.sort.Sorting;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SortingTest {
    CustomArray customArray;
    int[] array = {11, 9, -5, 2, 8};
    CustomArray expected;
    CustomArray expectedEvenOdd;
    Sorting sorting;

    @BeforeClass
    public void setUp() throws CustomArrayException {
        sorting = new Sorting();
        expected = new CustomArray(-5, 2, 8, 9, 11);
        expectedEvenOdd= new CustomArray(9,11,2,-5,8);
    }

    @Test(description = "Test bubble sort")
    public void bubbleSortTest() throws CustomArrayException {
        customArray = new CustomArray(array);
        sorting.bubbleSort(customArray);
        assertEquals(expected ,customArray);
    }

    @Test(description = "Test shaker sort")
    public void shakerSortTest() throws CustomArrayException {
        customArray = new CustomArray(array);
        sorting.shakerSort(customArray);
        assertEquals(expected ,customArray);
    }

    @Test(description = "Test insert sort")
    public void insertSortTest() throws CustomArrayException {
        customArray = new CustomArray(array);
        sorting.insertSort(customArray);
        assertEquals(expected ,customArray);
    }

    @Test(description = "Test stream sort")
    public void streamSortTest() throws CustomArrayException {
        customArray = new CustomArray(array);
        sorting.streamSort(customArray);
        assertEquals(expected ,customArray);
    }

    @Test(description = "Test of swap by condition")
    public void swapEvenOddTest() throws CustomArrayException {
        customArray = new CustomArray(11,9,-5,2,8);
        sorting.swapOddWithEvenElements(customArray);
        assertEquals(expectedEvenOdd ,customArray);
    }
}
