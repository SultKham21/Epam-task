package read;

import array.exception.CustomArrayException;
import array.read.FileReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import static org.testng.Assert.assertEquals;

public class FileReaderTest {

    String pathName;
    String noPathName;
    String noDataPath;
    List<String> expected;
    FileReader fileReader;
    List<int[]> intList;

    @BeforeClass
    public void setUp() throws IOException, CustomArrayException {
        fileReader = new FileReader();
        intList = new ArrayList<>();
        pathName = "resources\\testdata\\data.txt";
        noPathName = "resources\\testdata\\nofile.txt";
        noDataPath = "resources\\testdata\\nodata.txt";
    }

    @Test
    public void testReadFileCorrect() throws IOException {
        List<String> actual = fileReader.generateStringListFromFile(pathName);
        expected = new ArrayList<>();
        expected.add("2 -70 51 -85 90 -72 18 71 2 0");
        expected.add("-3 d8 22 11");
        expected.add("");
        expected.add("8 10 - 3 15");
        expected.add("1 -2 3 10 -4");
        assertEquals(actual, expected);
    }

    @Test
    public void testGenerateIntList() throws CustomArrayException,IOException {
        List<int[]> intList = fileReader.generateIntArrayListFromStringList(fileReader.generateStringListFromFile(pathName));
        int[] actual = intList.get(0);
        int[] expected={2, -70, 51, -85, 90, -72, 18, 71, 2, 0};
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IOException.class)
    public void testReadFileNoFile() throws IOException {
        fileReader.generateStringListFromFile(noPathName);
    }

    @Test(expectedExceptions = IOException.class)
    public void testReadFileNoData() throws IOException {
        fileReader.generateStringListFromFile(noDataPath);
    }
}
