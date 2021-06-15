package services.change;

import array.entity.CustomArray;
import array.exception.CustomArrayException;

import array.read.FileReader;
import array.services.change.ChangeValueByCondition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ChangeValueByConditionTest {

    ChangeValueByCondition changeValueByCondition;
    CustomArray customArray;

    @BeforeClass
    public void setUp() throws CustomArrayException {
        changeValueByCondition = new ChangeValueByCondition();
        customArray = new CustomArray(1,8,-6,9,13,-8,6);
    }

    @Test
    public void testChangeEven() throws CustomArrayException {
        CustomArray expected = new CustomArray(5,8,5,9,5,-8,5);
        changeValueByCondition.changeEvenElements(customArray,5);
        assertEquals(customArray,expected);
    }

    @Test
    public void testChangeOddInRange() throws CustomArrayException {
        CustomArray expected = new CustomArray(1,5,-6,5,13,-8,6);
        changeValueByCondition.changeOddElementsInRange(customArray,5,0,4);
        assertEquals(customArray,expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testChangeOddInRangeIncorrect() throws CustomArrayException {
        changeValueByCondition.changeOddElementsInRange(customArray,5,5,1);
    }
}
