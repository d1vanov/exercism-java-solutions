import java.util.ArrayList;
import java.util.List;

class LuhnValidator
{

    boolean isValid(String candidate)
    {
        try {
            candidate = filterSpaces(candidate);
            if (candidate.length() <= 1) {
                return false;
            }

            candidate = reverse(candidate);
            int csr = checksumRemainder(candidate);
            return csr == 0;
        }
        catch(Exception e) {
            return false;
        }
    }

    private final List<Integer> addends(String candidate)
    {
        ArrayList<Integer> digits = new ArrayList<>(candidate.length());
        for(int i = 0; i < candidate.length(); ++i)
        {
            char c = candidate.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Character is not a digit");
            }

            int digit = Character.getNumericValue(c);

            if (i == 0 || i % 2 == 0) {
                digits.add(digit);
                continue;
            }

            digit *= 2;
            if (digit >= 10) {
                digit -= 9;
            }

            digits.add(digit);
        }

        return digits;
    }

    private final int checksum(List<Integer> digits)
    {
        return digits.stream().reduce(0, Integer::sum);
    }

    private final int checksumRemainder(String candidate)
    {
        List<Integer> digits = addends(candidate);
        int cs = checksum(digits);
        return cs % 10;
    }

    private final String reverse(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    private final String filterSpaces(String str)
    {
        return str.replaceAll(" ", "");
    }
}
