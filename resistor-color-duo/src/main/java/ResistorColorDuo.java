class ResistorColorDuo {
    int value(String[] colors) {
        int multiplier = (int)Math.pow(10, Math.min(2, colors.length) - 1);
        int result = 0;

        int counter = 0;
        for(String color: colors) {
            switch(color.toLowerCase()) {
                case "black":
                    continue;
                case "brown":
                    result += multiplier;
                    break;
                case "red":
                    result += 2 * multiplier;
                    break;
                case "orange":
                    result += 3 * multiplier;
                    break;
                case "yellow":
                    result += 4 * multiplier;
                    break;
                case "green":
                    result += 5 * multiplier;
                    break;
                case "blue":
                    result += 6 * multiplier;
                    break;
                case "violet":
                    result += 7 * multiplier;
                    break;
                case "grey":
                    result += 8 * multiplier;
                    break;
                case "white":
                    result += 9 * multiplier;
                    break;
                default:
                    throw new IllegalArgumentException("Bad color code: " + String.join("-", colors));
            }

            counter += 1;
            if (counter == 2) {
                break;
            }

            multiplier /= 10;

        }

        return result;
    }
}
