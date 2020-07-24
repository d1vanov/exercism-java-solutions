class CustomUncheckedException extends RuntimeException
{
    String m_message;

    CustomUncheckedException()
    {}

    CustomUncheckedException(String message)
    {
        m_message = message;
    }

    @Override
    public String getMessage()
    {
        return m_message;
    }
}
