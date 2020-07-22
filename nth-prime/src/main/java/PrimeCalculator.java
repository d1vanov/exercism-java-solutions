import java.util.ArrayList;
import java.util.List;

class PrimeCalculator
{
    int nth(int nth)
    {
        if (nth <= 0) {
            throw new IllegalArgumentException("Invalid index for prime number");
        }

        List<Integer> primes = generatePrimes(1000005);
        return primes.get(nth - 1);
    }

    private final List<Integer> generatePrimes(int maxValue)
    {
        List<Integer> primes = new ArrayList<Integer>();

        List<Boolean> isPrime = new ArrayList<Boolean>(maxValue);
        for(int i = 0; i < maxValue; ++i) {
            isPrime.add(true);
        }

        int p = 2;
        while(p * p < maxValue)
        {
            if (isPrime.get(p))
            {
                int i = p * p;
                while(i < maxValue) {
                    isPrime.set(i, false);
                    i += p;
                }
            }

            p += 1;
        }

        for(p = 2; p < maxValue; ++p)
        {
            if (isPrime.get(p)) {
                primes.add(p);
            }
        }

        return primes;
    }
}
