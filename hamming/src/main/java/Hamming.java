public class Hamming {
    String m_leftStrand;
    String m_rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        m_leftStrand = leftStrand;
        m_rightStrand = rightStrand;
    }

    public int getHammingDistance() {
        int count = 0;
        for(int i = 0; i < m_leftStrand.length(); ++i) {
            if (m_leftStrand.charAt(i) != m_rightStrand.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
