import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Scrabble {
    private static final Map<Character, Integer> m_map;

    static {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 1);
        map.put('E', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('U', 1);
        map.put('L', 1);
        map.put('N', 1);
        map.put('R', 1);
        map.put('S', 1);
        map.put('T', 1);
        map.put('D', 2);
        map.put('G', 2);
        map.put('B', 3);
        map.put('C', 3);
        map.put('M', 3);
        map.put('P', 3);
        map.put('F', 4);
        map.put('H', 4);
        map.put('V', 4);
        map.put('W', 4);
        map.put('Y', 4);
        map.put('K', 5);
        map.put('J', 8);
        map.put('X', 8);
        map.put('Q', 10);
        map.put('Z', 10);
        m_map = Collections.unmodifiableMap(map);
    }

    int m_score;

    Scrabble(String word) {
        word = word.toUpperCase();
        m_score = 0;
        for(int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            Integer value = m_map.get(c);
            if (value != null) {
                m_score += value;
            }
        }
    }

    int getScore() {
        return m_score;
    }

}
