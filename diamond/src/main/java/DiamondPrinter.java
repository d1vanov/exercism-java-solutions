import java.util.ArrayList;
import java.util.List;

class DiamondPrinter
{
    List<String> printToList(char a)
    {
        int n = (int)a - (int)'A';
        int m = 2 * n + 1;

        List<Integer> letters = new ArrayList<Integer>(n + 1);
        for(int i = 0; i <= n; ++i) {
            letters.add((int)'A' + i);
        }

        List<String> rows = new ArrayList<String>(letters.size());
        for(int i = 0; i < letters.size(); ++i)
        {
            List<Character> row = new ArrayList<Character>(m);
            for(int j = 0; j < m; ++j) {
                row.add(' ');
            }

            char letter = (char)letters.get(i).intValue();
            row.set(n - i, letter);
            row.set(n + i, letter);

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < row.size(); ++j) {
                sb.append(row.get(j));
            }

            rows.add(sb.toString());
        }

        List<String> result = new ArrayList<String>(rows.size() * 2);

        for(int i = 0; i < rows.size(); ++i) {
            result.add(rows.get(i));
        }

        for(int i = 0; i < (rows.size() - 1); ++i) {
            result.add(rows.get(rows.size() - i - 2));
        }

        return result;
    }
}
