import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Yacht {
    List<Integer> m_dice;
    YachtCategory m_category;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        m_dice = new ArrayList<Integer>(dice.length);
        for(int i = 0; i < dice.length; ++i) {
            m_dice.add(dice[i]);
        }
        m_category = yachtCategory;
    }

    int score()
    {
        switch(m_category)
        {
            case YACHT:
                for(int i = 1; i < m_dice.size(); ++i) {
                    if (!m_dice.get(i).equals(m_dice.get(i - 1))) {
                        return 0;
                    }
                }

                return 50;
            case ONES:
                return sumScore(1);
            case TWOS:
                return sumScore(2);
            case THREES:
                return sumScore(3);
            case FOURS:
                return sumScore(4);
            case FIVES:
                return sumScore(5);
            case SIXES:
                return sumScore(6);
            case FULL_HOUSE:
                {
                    Map<Integer, Integer> itemCounts = getItemCounts();
                    if (itemCounts.size() != 2) {
                        return 0;
                    }

                    int result = 0;
                    for(Map.Entry<Integer, Integer> entry: itemCounts.entrySet()) {
                        Integer count = entry.getValue();
                        if (count != 2 && count != 3) {
                            return 0;
                        }
                        result += count * entry.getKey();
                    }

                    return result;
                }
            case FOUR_OF_A_KIND:
                {
                    Map<Integer, Integer> itemCounts = getItemCounts();
                    for(Map.Entry<Integer, Integer> entry: itemCounts.entrySet()) {
                        if (entry.getValue() >= 4) {
                            return entry.getKey() * 4;
                        }
                    }
                    return 0;
                }
            case LITTLE_STRAIGHT:
            case BIG_STRAIGHT:
                {
                    List<Integer> dice = new ArrayList<Integer>(m_dice.size());
                    for(int i = 0; i < m_dice.size(); ++i) {
                        dice.add(m_dice.get(i));
                    }
                    Collections.sort(dice);

                    for(int i = 1; i < dice.size(); ++i) {
                        if (dice.get(i) - dice.get(i - 1) != 1) {
                            return 0;
                        }
                    }

                    if (m_category == YachtCategory.LITTLE_STRAIGHT && !dice.contains(1)) {
                        return 0;
                    }
                    else if (m_category == YachtCategory.BIG_STRAIGHT && dice.contains(1)) {
                        return 0;
                    }

                    return 30;
                }
            case CHOICE:
                return m_dice.stream().reduce(0, Integer::sum);
            default:
                return 0;
        }
    }

    private final int sumScore(int value)
    {
        int sum = 0;
        for(int i = 0; i < m_dice.size(); ++i) {
            if (m_dice.get(i).equals(value)) {
                ++sum;
            }
        }

        return value * sum;
    }

    private final Map<Integer, Integer> getItemCounts()
    {
        Map<Integer, Integer> itemCounts = new HashMap<Integer, Integer>();
        for(int i = 0; i < m_dice.size(); ++i) {
            Integer item = m_dice.get(i);
            Integer sum = itemCounts.getOrDefault(item, 0);
            itemCounts.put(item, sum + 1);
        }
        return itemCounts;
    }
}
