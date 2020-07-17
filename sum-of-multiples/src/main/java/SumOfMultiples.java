import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {

    int m_sum;

    SumOfMultiples(int number, int[] set) {
        m_sum = 0;
        Set<Integer> addedNumbers = new HashSet<Integer>();
        for(int i = 1; i < number; ++i) {
            if (addedNumbers.contains(i)) {
                continue;
            }

            for(int num: set) {
                if (num == 0) {
                    continue;
                }

                if (i % num == 0) {
                    m_sum += i;
                    addedNumbers.add(i);
                    break;
                }
            }
        }
    }

    int getSum() {
        return m_sum;
    }

}
