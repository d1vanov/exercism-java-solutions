import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix
{
    List<List<Integer>> m_values;

    Matrix(List<List<Integer>> values)
    {
        int rowSize = -1;
        for(List<Integer> row: values)
        {
            if (rowSize < 0) {
                rowSize = row.size();
            }
            else if (rowSize != row.size()) {
                throw new IllegalArgumentException("Irregular matrix");
            }
        }

        m_values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints()
    {
        List<List<Integer>> columns = new ArrayList<List<Integer>>();
        for(int i = 0; i < m_values.size(); ++i)
        {
            List<Integer> row = m_values.get(i);
            for(int j = 0; j < row.size(); ++j) {
                while(columns.size() <= j) {
                    columns.add(new ArrayList<Integer>());
                }

                columns.get(j).add(row.get(j));
            }
        }

        Set<MatrixCoordinate> result = new HashSet<MatrixCoordinate>();
        for(int i = 0; i < m_values.size(); ++i)
        {
            List<Integer> row = m_values.get(i);
            Integer maxRowItem = Collections.max(row);
            int lastMaxItemColumn = -1;

            while(true)
            {
                int maxItemColumn = -1;

                for(int j = lastMaxItemColumn + 1; j < row.size(); ++j)
                {
                    if (row.get(j).equals(maxRowItem)) {
                        maxItemColumn = j;
                        break;
                    }
                }

                if (maxItemColumn < 0) {
                    break;
                }

                lastMaxItemColumn = maxItemColumn;
                Integer minColumnItem = Collections.min(columns.get(maxItemColumn));
                if (minColumnItem.equals(row.get(maxItemColumn))) {
                    result.add(new MatrixCoordinate(i + 1, maxItemColumn + 1));
                }
            }
        }

        return result;
    }
}
