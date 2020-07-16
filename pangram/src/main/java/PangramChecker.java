import java.util.HashSet;

public class PangramChecker {

    public boolean isPangram(String input) {
        HashSet<Character> includedChars = new HashSet<Character>();
        input = input.toLowerCase();

        for(int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            includedChars.add(c);
        }

        for(char c = 'a'; c <= 'z'; ++c) {
            if (!includedChars.contains(c)) {
                return false;
            }
        }

        return true;
    }

}
