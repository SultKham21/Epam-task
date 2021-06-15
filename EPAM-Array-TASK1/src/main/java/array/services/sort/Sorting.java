package array.services.sort;

import array.entity.CustomArray;
import array.exception.CustomArrayException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class Sorting {

    private static final Logger log = LogManager.getLogger(Sorting.class);

    public void swapOddWithEvenElements(CustomArray array) throws CustomArrayException {

        int i = 0, j=1;

        for (;j<=array.getLength()-1;){
            array.swapElements(i,j);
            i+=2;
            j+=2;
        }

        log.info("Elements with even indexes was swapping with odd");
    }

    public void bubbleSort(CustomArray array) throws CustomArrayException {

        for (int i=0;i+1<array.getLength();i++){

            boolean flag=true;

            for (int j=0; j+1<array.getLength()-i; j++){
                if (array.getElement(j+1)<array.getElement(j)){

                    flag = false;

                    array.swapElements(j,j+1);
                }
            }

            if (flag){
                break;
            }
        }

        log.info("Bubble sort is complete");

    }

    public void shakerSort(CustomArray array) throws CustomArrayException {

        int left = 0, right = array.getLength() - 1;
        boolean flag = true;

        while ((left < right) && flag) {
            flag = false;
            for (int i = left; i < right; i++) {
                if (array.getElement(i) > array.getElement(i + 1))
                    array.swapElements(i, i + 1);
            }


            right--;

            for (int i = right; i > left; i--) {
                if (array.getElement(i - 1) > array.getElement(i)) {
                    array.swapElements(i - 1, i);
                    flag = true;
                }
            }
            left++;
        }

        log.info("Shaker sort is complete");

    }

    public void insertSort(CustomArray array) throws CustomArrayException {
        for (int i = 1; i < array.getLength(); i++) {
            int currElem = array.getElement(i);
            int prevKey = i - 1;
            while (prevKey >= 0 && array.getElement(prevKey) > currElem) {
                array.setElement(prevKey + 1, array.getElement(prevKey));
                array.setElement(prevKey, currElem);
                prevKey--;
            }
        }
        log.info("Insert sort is complete");
    }

    public void streamSort(CustomArray array) throws CustomArrayException {

        array.setArray(Arrays.stream(array.getArray()).sorted().toArray());

        log.info("Sorting use InrStream is complete");
    }

}
