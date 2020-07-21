class CollatzCalculator
{
    int computeStepCount(int start)
    {
        if (start <= 0) {
            throw new IllegalArgumentException(
                "Only natural numbers are allowed");
        }

        int n = start;
        int counter = 0;
        while(n > 1)
        {
            ++counter;

            if (n % 2 == 0) {
                n = n / 2;
                continue;
            }

            n *= 3;
            n += 1;
        }

        return counter;
    }
}
