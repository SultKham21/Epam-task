package services.search;

import array.entity.CustomArray;
import array.exception.CustomArrayException;
import array.services.change.ChangeValueByCondition;
import array.services.search.SearchElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SearchElementTest {
    SearchElement searchElement;
    CustomArray customArray;

    @BeforeClass
    public void setUp() throws CustomArrayException {
        searchElement = new SearchElement();
        customArray = new CustomArray(1,8,-6,9,13,-8,6);
    }

    @Test
    public void testSearchMin() throws CustomArrayException {
        int expected = -8;
        int actual = searchElement.searchMin(customArray);
        assertEquals(actual,expected);
    }

    @Test
    public void testSearchMax() throws CustomArrayException {
        int expected = 13;
        int actual = searchElement.searchMax(customArray);
        assertEquals(actual,expected);
    }

    @Test
    public void testSearchMinStream() {
        int expected = -8;
        int actual = searchElement.searchMinStream(customArray);
        assertEquals(actual,expected);
    }

    @Test
    public void testSearchMaxStream() {
        int expected =13;
        int actual = searchElement.searchMaxStream(customArray);
        assertEquals(actual,expected);
    }
}
