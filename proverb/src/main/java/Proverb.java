class Proverb
{
    String[] m_words;

    Proverb(String[] words)
    {
        m_words = words;
    }

    String recite()
    {
        if (m_words.length == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < m_words.length - 1; ++i) {
            builder.append(forWant(m_words[i], m_words[i + 1]));
        }

        builder.append("And all for the want of a ");
        builder.append(m_words[0]);
        builder.append(".");

        return builder.toString();
    }

    private final String forWant(String first, String second)
    {
        return "For want of a " + first + " the " + second + " was lost.\n";
    }
}
