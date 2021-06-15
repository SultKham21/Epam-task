package array.generate;

import array.entity.CustomArray;
import array.exception.CustomArrayException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayGenerate {

    private static final Logger log = LogManager.getLogger(CustomArrayGenerate.class);

    public List<CustomArray> generateCustomArrayList(List<int[]> intArrayList) throws CustomArrayException {

        ArrayList<CustomArray> customArrayList = new ArrayList<>();

        if (intArrayList == null || intArrayList.isEmpty()) {
            log.error("ArrayList is empty");
            throw new CustomArrayException("ArrayList has no elements");
        }

        for (int[] array : intArrayList) {
            customArrayList.add(new CustomArray(array));
        }

        log.info("Generate CustomArray list is successful");

        return customArrayList;
    }

}
