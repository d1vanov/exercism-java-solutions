import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        boolean shouldReverse = false;
        if (number >= 16) {
            shouldReverse = true;
            number -= 16;
        }

        ArrayList<Signal> secrets = new ArrayList<Signal>(4);

        if (number >= 8) {
            secrets.add(Signal.JUMP);
            number -= 8;
        }

        if (number >= 4) {
            secrets.add(Signal.CLOSE_YOUR_EYES);
            number -= 4;
        }

        if (number >= 2) {
            secrets.add(Signal.DOUBLE_BLINK);
            number -= 2;
        }

        if (number >= 1) {
            secrets.add(Signal.WINK);
            number -= 1;
        }

        if (!shouldReverse) {
            Collections.reverse(secrets);
        }

        return secrets;
    }

}
