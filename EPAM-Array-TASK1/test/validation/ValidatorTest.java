package validation;

import array.entity.CustomArray;
import array.exception.CustomArrayException;
import array.services.search.SearchElement;
import array.validation.Validator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ValidatorTest {
    String correctString;
    String incorrectSring;

    @BeforeClass
    public void setUp() throws CustomArrayException {
        correctString = "8 5 -20 30 6 8 1";
        incorrectSring = "lop58 27 iyt 2z";
    }

    @Test
    public void testValidatorCorrect(){
        boolean expected = true;
        boolean actual = Validator.isInputCorrect(correctString);
        assertEquals(actual,expected);
    }

    @Test
    public void testValidatorIncorrect() {
        boolean expected = false;
        boolean actual = Validator.isInputCorrect(incorrectSring);
        assertEquals(actual,expected);
    }
}
