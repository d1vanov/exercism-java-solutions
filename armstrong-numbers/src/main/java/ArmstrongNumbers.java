import java.util.ArrayList;
import java.util.List;

class ArmstrongNumbers {
    boolean isArmstrongNumber(int numberToCheck) {
        List<Integer> digits = new ArrayList<>();

        int next = numberToCheck;
        while(next / 10 > 0) {
            digits.add(next % 10);
            next /= 10;
        }
        digits.add(next); // add last digit

        int value = 0;
        for(Integer digit: digits) {
            value += Math.pow(digit, digits.size());
        }

        return value == numberToCheck;
    }
}
