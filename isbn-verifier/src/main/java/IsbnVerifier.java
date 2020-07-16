class IsbnVerifier
{
    boolean isValid(String stringToVerify)
    {
        stringToVerify = stringToVerify.replaceAll("[^\\p{IsAlphabetic}\\p{IsDigit}]", "");
        if (stringToVerify.length() < 9 || stringToVerify.length() > 10) {
            return false;
        }

        int result = 0;
        for(int i = 0; i < stringToVerify.length(); ++i)
        {
            char chr = stringToVerify.charAt(i);

            if (i != stringToVerify.length() - 1)
            {
                if (!Character.isDigit(chr)) {
                    return false;
                }

                result += (10 - i) * Character.getNumericValue(chr);
            }
            else
            {
                if (chr == 'X') {
                    result += 10;
                }
                else if (!Character.isDigit(chr)) {
                    return false;
                }
                else {
                    result += Character.getNumericValue(chr);
                }
            }
        }

        return result % 11 == 0;
    }
}
