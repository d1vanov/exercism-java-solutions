import java.util.HashSet;
import java.util.Set;

class PigLatinTranslator
{
    private static final Set<Character> m_vowels = new HashSet<Character>();

    static
    {
        m_vowels.add('a');
        m_vowels.add('e');
        m_vowels.add('i');
        m_vowels.add('o');
        m_vowels.add('u');
        m_vowels.add('y');
    }

    public String translate(String input)
    {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word: words) {
            result.append(translateWord(word));
            result.append(" ");
        }
        String resultStr = result.toString();
        resultStr = resultStr.substring(0, resultStr.length() - 1);
        return resultStr;
    }

    private final boolean isVowel(char c, int index, String word)
    {
        int wordLen = word.length();
        if (c == 'y' && index != (wordLen - 1) &&
                m_vowels.contains(word.charAt(index + 1)))
        {
            return false;
        }
        else if (c == 'x' && index != (wordLen - 1) &&
                !m_vowels.contains(word.charAt(index + 1)))
        {
            return true;
        }
        else if (c == 'u' && index != 0 &&
                word.charAt(index - 1) == 'q')
        {
            return false;
        }

        return m_vowels.contains(c);
    }

    private final String translateWord(String word)
    {
        StringBuilder consolantPart = new StringBuilder();
        for(int i = 0; i < word.length(); ++i)
        {
            char c = word.charAt(i);

            if (isVowel(c, i, word))
            {
                int consolantPartLen = consolantPart.length();
                if (consolantPartLen != 0) {
                    word = word.substring(consolantPartLen);
                }

                return word + consolantPart + "ay";
            }

            consolantPart.append(c);
        }

        return word + "ay";
    }
}
