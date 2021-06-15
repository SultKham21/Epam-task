package array.read;

import array.exception.CustomArrayException;
import array.validation.Validator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private static final Logger log = LogManager.getLogger(FileReader.class);

    public List<String> generateStringListFromFile(String filePath) throws IOException {

        File dataFile = new File(filePath);

        if (dataFile.length() == 0) {
            throw new IOException("File has no data");
        }

        List<String> strings = Files.readAllLines(Path.of(filePath));

        log.info("File reading complete");

        return strings;
    }

    public List<int[]> generateIntArrayListFromStringList(List<String> stringList) throws CustomArrayException {


        if (stringList == null || stringList.isEmpty()) {
            log.error("StringList is empty");
            throw new CustomArrayException("List has no elements");
        }

        ArrayList<int[]> intArrayList = new ArrayList<>();

        for (String arrayString : stringList) {
            if (Validator.isInputCorrect(arrayString)) {

                String[] correctArray = arrayString.split("\\s+");

                int[] array = new int[correctArray.length];

                for (int i = 0; i < correctArray.length; i++) {
                    array[i] = Integer.parseInt(correctArray[i]);
                }

                intArrayList.add(array);
            }
        }

        if (!intArrayList.isEmpty()){
            log.info("IntArrayList generate successfully");
        }
        else {
            log.info("StringList has no correct string");
        }

        return intArrayList;
    }

}

