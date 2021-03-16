package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {
    
    private Set<Integer> digits = new HashSet<>();
    
    public int getCountOfDigits(String s) {
        if (s == null || s.isBlank()) {
            return 0;
        }
        for (char letter : s.toCharArray()) {
            if (Character.isDigit(letter)) {
                digits.add(Character.getNumericValue(letter));
            }
        }
        return digits.size();
    }
}
