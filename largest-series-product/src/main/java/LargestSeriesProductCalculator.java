class LargestSeriesProductCalculator
{
    String m_inputNumber;

    LargestSeriesProductCalculator(String inputNumber)
    {
        m_inputNumber = inputNumber;
        for(int i = 0; i < m_inputNumber.length(); ++i) {
            if (!Character.isDigit(m_inputNumber.charAt(i))) {
                throw new IllegalArgumentException("String to search may only contain digits.");
            }
        }
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits)
    {
        int inputNumberDigitCount = m_inputNumber.length();
        if (numberOfDigits > inputNumberDigitCount) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        if (numberOfDigits == 0) {
            return 1;
        }

        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        long maxProduct = 0;
        int index = 0;
        int startIndex = 0;
        long currentProduct = 1;

        while(index < inputNumberDigitCount)
        {
            int currentDigit = Character.getNumericValue(m_inputNumber.charAt(index));
            if (currentDigit == 0) {
                currentProduct = 1;
                ++index;
                startIndex = index;
                continue;
            }

            currentProduct *= currentDigit;
            ++index;
            if (index - startIndex == numberOfDigits)
            {
                if (currentProduct > maxProduct) {
                    maxProduct = currentProduct;
                }

                currentProduct /= Character.getNumericValue(m_inputNumber.charAt(startIndex));
                ++startIndex;
            }
        }

        return maxProduct;
    }
}
