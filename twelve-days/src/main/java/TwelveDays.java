class TwelveDays
{
    String verse(int verseNumber)
    {
        if (verseNumber < 1 || verseNumber > 12) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("On the ");
        sb.append(dayNumber(verseNumber));
        sb.append(" day of Christmas my true love gave to me");

        for(int j = verseNumber; j >= 1; --j)
        {
            if (j == verseNumber) {
                sb.append(": ");
            }
            else {
                sb.append(", ");
            }

            if (j == 1 && verseNumber > 1) {
                sb.append("and ");
            }
            sb.append(what(j));
        }

        sb.append(".\n");
        return sb.toString();
    }

    String verses(int startVerse, int endVerse)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = startVerse; i <= endVerse; ++i) {
            sb.append(verse(i));
            if (i != endVerse) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
    String sing()
    {
        return verses(1, 12);
    }

    private final String dayNumber(int i)
    {
        if (i < 1 || i > 12) {
            return "";
        }

        switch(i)
        {
        case 1:
            return "first";
        case 2:
            return "second";
        case 3:
            return "third";
        case 4:
            return "fourth";
        case 5:
            return "fifth";
        case 6:
            return "sixth";
        case 7:
            return "seventh";
        case 8:
            return "eighth";
        case 9:
            return "ninth";
        case 10:
            return "tenth";
        case 11:
            return "eleventh";
        case 12:
            return "twelfth";
        default:
            return "";
        }
    }

    private final String what(int i)
    {
        if (i < 1 || i > 12) {
            return "";
        }

        switch(i)
        {
        case 1:
            return "a Partridge in a Pear Tree";
        case 2:
            return "two Turtle Doves";
        case 3:
            return "three French Hens";
        case 4:
            return "four Calling Birds";
        case 5:
            return "five Gold Rings";
        case 6:
            return "six Geese-a-Laying";
        case 7:
            return "seven Swans-a-Swimming";
        case 8:
            return "eight Maids-a-Milking";
        case 9:
            return "nine Ladies Dancing";
        case 10:
            return "ten Lords-a-Leaping";
        case 11:
            return "eleven Pipers Piping";
        case 12:
            return "twelve Drummers Drumming";
        default:
            return "";
        }
    }
}
