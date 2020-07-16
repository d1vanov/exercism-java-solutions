import java.math.BigDecimal;
import java.math.RoundingMode;

class SpaceAge {
    double m_seconds;

    SpaceAge(double seconds) {
        m_seconds = seconds;
    }

    double getSeconds() {
        return m_seconds;
    }

    double onEarth() {
        return round(onEarthImpl());
    }

    double onMercury() {
        double earthYears = onEarthImpl();
        return round(earthYears / 0.2408467);
    }

    double onVenus() {
        double earthYears = onEarthImpl();
        return round(earthYears / 0.61519726);
    }

    double onMars() {
        double earthYears = onEarthImpl();
        return round(earthYears / 1.8808158);
    }

    double onJupiter() {
        double earthYears = onEarthImpl();
        return round(earthYears / 11.862615);
    }

    double onSaturn() {
        double earthYears = onEarthImpl();
        return round(earthYears / 29.447498);
    }

    double onUranus() {
        double earthYears = onEarthImpl();
        return round(earthYears / 84.016846);
    }

    double onNeptune() {
        double earthYears = onEarthImpl();
        return round(earthYears / 164.79132);
    }

    private double round(final double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private double onEarthImpl()
    {
        return m_seconds / 31557600.0;
    }

}
