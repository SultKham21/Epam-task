package array.entity;

import array.exception.CustomArrayException;
import array.services.sort.Sorting;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CustomArray {

    private static final Logger log = LogManager.getLogger(CustomArray.class);

    private int[] array;

    public CustomArray(int... array) throws CustomArrayException {

        if (array == null || array.length == 0) {
            log.error("Incorrect attempt to initialize CustomArray");
            throw new CustomArrayException("Array has no elements");
        }

        this.array = array;
        log.info("CustomArray has been initialized");
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public int getElement(int index) throws CustomArrayException {

        if (index < 0 || index >= array.length) {
            log.error("Bad attempt to getElement");
            throw new CustomArrayException("Index is out of bounds");
        }

        return array[index];
    }

    public int[] getRange(int from, int to) throws CustomArrayException {

        if (from > to||from<0||to>=array.length) {
            log.error("Bad attempt to getRange");
            throw new CustomArrayException("Incorrect index data");
        }

        return Arrays.copyOfRange(this.array, from, to);
    }

    public void setArray(int... array) throws CustomArrayException {

        if (array == null || array.length == 0) {
            log.error("Bad attempt to setArray");
            throw new CustomArrayException("Array has no elements");
        }

        this.array = array;
    }

    public void setElement(int index, int value) throws CustomArrayException {

        if (index < 0 || index >= array.length) {
            log.error("Bad attempt to setElement");
            throw new CustomArrayException("Index is out of bounds");

        }

        this.array[index] = value;
    }

    public void setRange(int from, int to, int... array) throws CustomArrayException {

        if (array == null || array.length == 0) {
            log.error("Range is empty");
            throw new CustomArrayException("Array has no elements");
        }

        if (to - from != array.length || to >= this.array.length || from < 0 || from > to) {
            log.error("Bad attempt to setRange");
            throw new CustomArrayException("Incorrect range of array");
        }

        for (int i = from; i <= to; i++) {
            this.array[i] = array[i];
        }
    }

    public int getLength() {
        return array.length;
    }

    public void swapElements(int firstIndex, int secondIndex) throws CustomArrayException {

        if (firstIndex < 0 || secondIndex > array.length || firstIndex > secondIndex) {
            log.error("Bad attempt to swapElements");
            throw new CustomArrayException("Incorrect index data");
        }

        int temp;

        temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

}