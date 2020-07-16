class Acronym {
    String m_acronym;

    Acronym(String phrase)
    {
        StringBuilder result = new StringBuilder();
        char firstSymbolOfCurrentWord = 0;
        boolean inWord = false;

        for(int i = 0; i < phrase.length(); ++i)
        {
            char c = phrase.charAt(i);

            boolean isWordCharacter = !Character.isWhitespace(c) &&
                Character.isLetterOrDigit(c);

            if (inWord)
            {
                if (!isWordCharacter)
                {
                    result.append(firstSymbolOfCurrentWord);
                    firstSymbolOfCurrentWord = 0;
                    inWord = false;
                }
                else
                {
                    boolean capitalizedSymbolWithLowerLeftNeighbor = false;
                    if (i != 0) {
                        char previousCharacter = phrase.charAt(i - 1);
                        capitalizedSymbolWithLowerLeftNeighbor =
                            ((c == Character.toUpperCase(c)) &&
                             (previousCharacter != Character.toUpperCase(previousCharacter)));
                    }

                    if (capitalizedSymbolWithLowerLeftNeighbor) {
                        result.append(firstSymbolOfCurrentWord);
                        firstSymbolOfCurrentWord = c;
                    }
                }
            }
            else if (isWordCharacter)
            {
                if (i > 2)
                {
                    char previousCharacter = phrase.charAt(i - 1);
                    char previousPreviousCharacter = phrase.charAt(i - 2);
                    if ((previousCharacter == '\'') &&
                            Character.isLetterOrDigit(previousPreviousCharacter) &&
                            (c == 's'))
                    {
                        // Ignoring character after the apostrophe
                        continue;
                    }
                }

                firstSymbolOfCurrentWord = Character.toUpperCase(c);
                inWord = true;
            }
        }

        if (firstSymbolOfCurrentWord != 0) {
            result.append(firstSymbolOfCurrentWord);
        }

        m_acronym = result.toString();
    }

    String get()
    {
        return m_acronym;
    }

}
