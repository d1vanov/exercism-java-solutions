import java.util.HashSet;
import java.util.Set;

class IsogramChecker
{
    boolean isIsogram(String phrase)
    {
        Set<Character> chars = new HashSet<Character>();

        for(int i = 0; i < phrase.length(); ++i)
        {
            char c = phrase.charAt(i);
            if (!Character.isAlphabetic(c)) {
                continue;
            }

            c = Character.toLowerCase(c);
            if (chars.contains(c)) {
                return false;
            }

            chars.add(c);
        }

        return true;
    }
}
