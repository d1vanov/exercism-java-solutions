import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

class Flattener
{
    Flattener()
    {}

    List<Object> flatten(List<Object> input)
    {
        List<Object> result = new ArrayList<Object>();

        for(int i = 0; i < input.size(); ++i)
        {
            Object item = input.get(i);
            if (item == null) {
                continue;
            }

            if (item instanceof List<?>) {
                result.addAll(flatten((List<Object>)item));
                continue;
            }

            result.add(item);
        }

        return result;
    }
}
