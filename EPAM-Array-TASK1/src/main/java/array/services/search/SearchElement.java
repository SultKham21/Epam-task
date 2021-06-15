package array.services.search;

import array.entity.CustomArray;
import array.exception.CustomArrayException;

import java.util.Arrays;

public class SearchElement {


    public int searchMin(CustomArray array) throws CustomArrayException {

        int min = array.getElement(0);

        for (int index=0; index<=array.getLength()-1; index++){
            if (array.getElement(index)<min){
                min= array.getElement(index);
            }
        }
        return min;
    }

    public int searchMax(CustomArray array) throws CustomArrayException {

        int max = array.getElement(0);

        for (int index=0; index<=array.getLength()-1; index++){
            if (array.getElement(index)>max){
                max= array.getElement(index);
            }
        }

        return max;
    }

    public int searchMinStream (CustomArray array){

        return Arrays.stream(array.getArray()).min().getAsInt();
    }

    public int searchMaxStream (CustomArray array){

        return Arrays.stream(array.getArray()).max().getAsInt();
    }
}
