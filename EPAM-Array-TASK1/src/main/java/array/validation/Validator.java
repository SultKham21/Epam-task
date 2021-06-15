package array.validation;


public class Validator {

    private static final String ARRAY_NUM_REGEX = "-?\\d+((\\s+-?\\d+)?)+$";

    public static boolean isInputCorrect(String input){
        return input.matches(ARRAY_NUM_REGEX);
    }
}
