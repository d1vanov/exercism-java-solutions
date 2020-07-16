import java.util.Arrays;
import java.util.Random;

class DnDCharacter {
    Random m_random;
    int[] m_abilities;

    DnDCharacter()
    {
        m_random = new Random();
        m_abilities = new int[6];

        for(int i = 0; i < m_abilities.length; ++i)
        {
            int[] rolls = new int[4];
            for(int j = 0; j < rolls.length; ++j) {
                rolls[j] = (1 + m_random.nextInt(5));
            }
            Arrays.sort(rolls);

            int sum = 0;
            for(int j = 1; j < rolls.length; ++j) {
                sum += rolls[j];
            }

            m_abilities[i] = sum;
        }
    }

    int ability() {
        int index = m_random.nextInt() % m_abilities.length;
        return m_abilities[index];
    }

    int modifier(int input) {
        return (int)Math.floor((input - 10) * 0.5);
    }

    int getStrength() {
        return m_abilities[0];
    }

    int getDexterity() {
        return m_abilities[1];
    }

    int getConstitution() {
        return m_abilities[2];
    }

    int getIntelligence() {
        return m_abilities[3];
    }

    int getWisdom() {
        return m_abilities[4];
    }

    int getCharisma() {
        return m_abilities[5];
    }

    int getHitpoints() {
        int mod = modifier(getConstitution());
        return mod + 10;
    }

}
