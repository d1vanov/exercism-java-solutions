class CustomCheckedException extends Exception
{
    String m_message;

    CustomCheckedException()
    {}

    CustomCheckedException(String message)
    {
        m_message = message;
    }

    @Override
    public String getMessage()
    {
        return m_message;
    }
}
