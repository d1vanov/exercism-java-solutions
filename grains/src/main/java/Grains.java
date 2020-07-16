import java.math.BigInteger;

class Grains {
    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }

        return BigInteger.valueOf(1).shiftLeft(square - 1);
    }

    BigInteger grainsOnBoard() {
        BigInteger one = BigInteger.valueOf(1);
        BigInteger value = one.shiftLeft(64);
        return value.subtract(one);
    }
}
