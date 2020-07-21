import java.util.ArrayList;
import java.util.List;

class KindergartenGarden
{
    String m_garden;

    static final String[] m_students =
    {
        "Alice", "Bob", "Charlie",
        "David", "Eve", "Fred", "Ginny",
        "Harriet", "Ileana", "Joseph",
        "Kincaid", "Larry"
    };

    KindergartenGarden(String garden)
    {
        m_garden = garden.replaceAll("\n", "");
    }

    List<Plant> getPlantsOfStudent(String student)
    {
        int index = -1;
        for(int i = 0; i < m_students.length; ++i) {
            if (m_students[i] == student) {
                index = i;
                break;
            }
        }

        if (index < 0) {
            throw new IllegalArgumentException("Wrong student name");
        }

        int offset = index * 2;
        int halfSize = m_garden.length() / 2;

        int[] plantIndices = {
            offset,
            offset + 1,
            halfSize + offset,
            halfSize + offset + 1
        };

        List<Plant> result = new ArrayList<Plant>(plantIndices.length);

        for(int plantIndex: plantIndices) {
            result.add(Plant.getPlant(m_garden.charAt(plantIndex)));
        }

        return result;
    }

}
