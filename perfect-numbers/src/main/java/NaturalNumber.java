class NaturalNumber {

    int m_number;

    NaturalNumber(int number)
    {
        if (number <= 0) {
            throw new IllegalArgumentException(
                "You must supply a natural number (positive integer)");
        }

        m_number = number;
    }

    Classification getClassification() {
        if (m_number == 1) {
            return Classification.DEFICIENT;
        }

        int divisorsSum = 1;
        int i = 2;
        while (i * i <= m_number) {
            if (m_number % i == 0) {
                divisorsSum += i;
                int otherDivisor = m_number / i;
                if (otherDivisor != i) {
                    divisorsSum += otherDivisor;
                }
            }

            i += 1;
        }

        if (divisorsSum == m_number) {
            return Classification.PERFECT;
        }
        else if (divisorsSum > m_number) {
            return Classification.ABUNDANT;
        }
        else {
            return Classification.DEFICIENT;
        }
    }

}
