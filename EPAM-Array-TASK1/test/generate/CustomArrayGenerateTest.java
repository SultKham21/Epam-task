package generate;

import array.entity.CustomArray;
import array.exception.CustomArrayException;
import array.generate.CustomArrayGenerate;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CustomArrayGenerateTest {

    CustomArrayGenerate customArrayGenerate;
    List<int[]> arrayList;
    List<CustomArray> customArrayList;


    @BeforeClass
    public void setUp() throws CustomArrayException {
        customArrayGenerate = new CustomArrayGenerate();
        arrayList = new ArrayList<>();
        arrayList.add(new int[]{1, 3, 4, 5});
        arrayList.add(new int[]{1,5});
        customArrayList = customArrayGenerate.generateCustomArrayList(arrayList);
    }

    @Test
    public void testCreateCustomArray() throws CustomArrayException {
        CustomArray actual = customArrayList.get(0);
        CustomArray expected = new CustomArray(1, 3, 4, 5);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testGenerateFromNull() throws CustomArrayException {
        arrayList = new ArrayList<>();
        customArrayGenerate.generateCustomArrayList(arrayList);
    }
}