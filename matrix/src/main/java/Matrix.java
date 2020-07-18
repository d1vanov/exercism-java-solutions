import java.util.ArrayList;
import java.util.List;

class Matrix
{
    List<int[]> m_rows;

    Matrix(String matrixAsString)
    {
        m_rows = new ArrayList<int[]>();
        String[] lines = matrixAsString.split("\\r?\\n");
        for(String line: lines) {
            String[] numbers = line.split("\\s+");
            int[] row = new int[numbers.length];
            for(int i = 0; i < numbers.length; ++i) {
                row[i] = Integer.parseInt(numbers[i]);
            }
            m_rows.add(row);
        }
    }

    int[] getRow(int rowNumber)
    {
        rowNumber -= 1;
        if (rowNumber >= m_rows.size()) {
            throw new IllegalArgumentException("Bad row number");
        }

        return m_rows.get(rowNumber);
    }

    int[] getColumn(int columnNumber)
    {
        if (m_rows.isEmpty()) {
            throw new IllegalStateException("Matrix is empty");
        }

        columnNumber -= 1;
        if (columnNumber >= m_rows.get(0).length) {
            throw new IllegalArgumentException("Bad column number");
        }

        int[] res = new int[m_rows.size()];
        for(int i = 0; i < m_rows.size(); ++i) {
            int[] row = m_rows.get(i);
            res[i] = row[columnNumber];
        }

        return res;
    }
}
