package tudelft.roman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanNumeral {

    private static Map<Character, Integer> map;

    static {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    //convert using map
//    public int convert(String s) {
//
//        int convertedNumber = 0;
//        for(int i = 0; i < s.length(); i++) {
//            int currentNumber = map.get(s.charAt(i));
//            int next = i+1 < s.length() ? map.get(s.charAt(i+1)) : 0;
//
//            if(currentNumber >= next)
//                convertedNumber += currentNumber;
//            else
//                convertedNumber -= currentNumber;
//        }
//
//        return convertedNumber;
//
//    }

    //convert using enum
    public int convert(String roman) throws IllegalArgumentException{

        roman = roman.toUpperCase();

        int convertedNumber = 0;

        List<RomanNumber> romanNumbers = RomanNumber.getValuesReverseSorted();

        int i = 0;
        while (roman.length() > 0 && i<romanNumbers.size()) {
            RomanNumber symbol = romanNumbers.get(i);
            if (roman.startsWith(symbol.name())) {
                convertedNumber = convertedNumber + symbol.getValue();
                roman = roman.substring(symbol.name().length());
            } else { i++; }
        }

        if (roman.length() > 0) {
            throw new IllegalArgumentException(roman + " illegal argument");
        }


        return convertedNumber;
    }

    public static String convert(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumber> romanNumerals = RomanNumber.getValuesReverseSorted();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumber currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
