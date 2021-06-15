package array.services.change;

import array.entity.CustomArray;
import array.exception.CustomArrayException;

public class ChangeValueByCondition {

    public void changeOddElements(CustomArray array, int value) throws CustomArrayException {

        for (int i = 1; i <= array.getLength(); i += 2) {
            array.setElement(i, value);
        }
    }

    public void changeOddElementsInRange(CustomArray array, int value, int from, int to) throws CustomArrayException {

        if (from > to || from < 0 || to >= array.getLength()) {
            throw new CustomArrayException("Incorrect index data");
        }

        int i = from;
        if (from % 2 == 0) i++;

        for (; i <= to; i += 2) {
            array.setElement(i, value);
        }
    }

    public void changeEvenElements(CustomArray array, int value) throws CustomArrayException {

        for (int i = 0; i <= array.getLength(); i += 2) {
            array.setElement(i, value);
        }
    }

}
