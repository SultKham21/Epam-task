package array.services.calculation;

import array.entity.CustomArray;
import array.exception.CustomArrayException;

import java.util.Arrays;

public class Calculation {

    public int calculateSum(CustomArray array) throws CustomArrayException {

        int sum=0;

        for (int index=0; index<=array.getLength()-1; index++){
            sum+=array.getElement(index);
        }
        return sum;
    }

    public int calculateNumberOfPositive(CustomArray array) throws CustomArrayException{

        int numofpositive = 0;

        for (int index=0; index<=array.getLength()-1; index++){
            if (array.getElement(index)>0) numofpositive++;
        }
        return numofpositive;
    }

    public int calculateNumberOfNegative(CustomArray array) throws CustomArrayException{

        int numofnegative = 0;

        for (int index=0; index<=array.getLength()-1; index++){
            if (array.getElement(index)<0) numofnegative++;
        }
        return numofnegative;
    }

    public double calculateAverageValue(CustomArray array) throws CustomArrayException {
        return calculateSum(array)/array.getLength();
    }

    public int calculateSumOfElementStream(CustomArray customArray) {

        return Arrays.stream(customArray.getArray()).sum();
    }
}
