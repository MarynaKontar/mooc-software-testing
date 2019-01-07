package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class RomanNumeralTestWithBeforeEach {

    private RomanNumeral roman;

    @BeforeEach
    public void initialize() {
        this.roman = new RomanNumeral();
    }

    @Test
    public void singleNumber() {
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void number5() {
        int result = roman.convert("V");
        Assertions.assertEquals(5, result);
    }

    @Test
    public void numberWithManyDigits() {
        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        int result = roman.convert("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        int result = roman.convert("LXXIV");
        Assertions.assertEquals(74, result);
    }

    @Test
    public void numberWithThreeSubtractiveNotation() {
        int result = roman.convert("CDXLIV");
        Assertions.assertEquals(444, result);
    }

    @Test
    public void biggestBorderNumber() {
        int result = roman.convert("MMMCMXCIX");
        Assertions.assertEquals(3999, result);
    }

    @Test
    public void given2018Roman() {
        int result = roman.convert("MMXVIII");
        Assertions.assertEquals(2018, result);
    }

//    @Test
//    public void givenException() {
//        int result = roman.convert("XXC");
//        Assertions.assertThrows(IllegalArgumentException.class, () -> roman.convert("XXC"));
//    }
}
