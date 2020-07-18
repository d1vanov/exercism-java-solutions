class Triangle
{
    enum Type
    {
        NotATriangle,
        Equilateral,
        Isosceles,
        Scalene
    }

    Type m_type;

    Triangle(double side1, double side2, double side3) throws TriangleException
    {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new TriangleException();
        }

        if (Double.isNaN(side1) || Double.isNaN(side2) || Double.isNaN(side3)) {
            throw new TriangleException();
        }

        if (!Double.isFinite(side1) || !Double.isFinite(side2) || !Double.isFinite(side3)) {
            throw new TriangleException();
        }

        if ( ((side1 + side2) < side3) ||
             ((side1 + side3) < side2) ||
             ((side2 + side3) < side1) )
        {
            throw new TriangleException();
        }

        if (side1 == side2 && side1 == side3) {
            m_type = Type.Equilateral;
        }
        else if (side1 == side2 || side1 == side3 || side2 == side3) {
            m_type = Type.Isosceles;
        }
        else {
            m_type = Type.Scalene;
        }
    }

    boolean isEquilateral()
    {
        return m_type == Type.Equilateral;
    }

    boolean isIsosceles()
    {
        return (m_type == Type.Isosceles) || (m_type == Type.Equilateral);
    }

    boolean isScalene()
    {
        return m_type == Type.Scalene;
    }
}
