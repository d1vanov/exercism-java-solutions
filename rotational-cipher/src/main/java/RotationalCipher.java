class RotationalCipher
{
    int m_shiftKey;

    RotationalCipher(int shiftKey)
    {
        m_shiftKey = shiftKey;
    }

    String rotate(String data)
    {
        if (m_shiftKey == 0) {
            return data;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < data.length(); ++i)
        {
            char c = data.charAt(i);
            if (!Character.isAlphabetic(c)) {
                sb.append(c);
                continue;
            }

            char base = (Character.isLowerCase(c) ? 'a' : 'A');
            sb.append((char)((int)base + (((int)c + m_shiftKey) - (int)base) % 26));
        }

        return sb.toString();
    }
}
