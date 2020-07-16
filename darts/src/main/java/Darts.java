class Darts {
    double m_x;
    double m_y;

    Darts(double x, double y) {
        m_x = x;
        m_y = y;
    }

    int score() {
        double distance = Math.sqrt(m_x * m_x + m_y * m_y);

        if (distance <= 1.0) {
            return 10;
        }
        else if (distance <= 5.0) {
            return 5;
        }
        else if (distance <= 10.0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
