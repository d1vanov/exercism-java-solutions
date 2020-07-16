import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigInteger;

public class Gigasecond {
    private static final BigInteger GIGASECOND = BigInteger.valueOf(10).pow(9);

    private final LocalDateTime m_datetime;

    public Gigasecond(LocalDate moment) {
        m_datetime = moment.atStartOfDay();
    }

    public Gigasecond(LocalDateTime moment) {
        m_datetime = moment;
    }

    public LocalDateTime getDateTime() {
        return m_datetime.plusSeconds(GIGASECOND.longValue());
    }
}
