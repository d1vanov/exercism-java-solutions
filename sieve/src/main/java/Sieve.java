import java.util.ArrayList;
import java.util.List;

class Sieve
{
    int m_maxPrime;

    Sieve(int maxPrime) {
        m_maxPrime = maxPrime;
    }

    List<Integer> getPrimes()
    {
        List<Integer> result = new ArrayList<Integer>();

        boolean[] flags = new boolean[m_maxPrime+1];
        for(int i = 0; i <= m_maxPrime; ++i) {
            flags[i] = (i >= 2);
        }

        for(int i = 0; i < flags.length; ++i)
        {
            if (!flags[i]) {
                continue;
            }

            result.add(i);
            for(int j = 0; j <= m_maxPrime; j += i) {
                flags[j] = false;
            }
        }

        return result;
    }
}
