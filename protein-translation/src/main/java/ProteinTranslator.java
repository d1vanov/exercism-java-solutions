import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ProteinTranslator {

    private static final Map<String, String> m_codons;
    private static final Set<String> m_stopCodons;

    static
    {
        Map<String, String> map = new HashMap<String, String>(7);
        map.put("AUG", "Methionine");
        map.put("UUU", "Phenylalanine");
        map.put("UUC", "Phenylalanine");
        map.put("UUA", "Leucine");
        map.put("UUG", "Leucine");
        map.put("UCU", "Serine");
        map.put("UCC", "Serine");
        map.put("UCA", "Serine");
        map.put("UCG", "Serine");
        map.put("UAU", "Tyrosine");
        map.put("UAC", "Tyrosine");
        map.put("UGU", "Cysteine");
        map.put("UGC", "Cysteine");
        map.put("UGG", "Tryptophan");
        m_codons = Collections.unmodifiableMap(map);

        Set<String> set = new HashSet<String>(3);
        set.add("UAA");
        set.add("UAG");
        set.add("UGA");
        m_stopCodons = Collections.unmodifiableSet(set);
    }

    List<String> translate(String rnaSequence)
    {
        List<String> result = new ArrayList<String>();
        int len = rnaSequence.length();

        for(int i = 0; i < len; i += 3)
        {
            if ((i + 2) >= len) {
                continue;
            }

            String codon = rnaSequence.substring(i, i + 3);
            if (m_stopCodons.contains(codon)) {
                break;
            }

            String value = m_codons.get(codon);
            if (value != null) {
                result.add(value);
            }
        }

        return result;
    }
}
