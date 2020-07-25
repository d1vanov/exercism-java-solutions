import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class VariableLengthQuantity
{
    List<String> encode(List<Long> numbers)
    {
        List<String> encoded = new ArrayList<String>();

        for(Long number: numbers)
        {
            List<String> bs = new ArrayList<String>();

            bs.add(String.format("0x%x", number & 0x7f));
            number >>= 7;
            while (number != 0) {
                bs.add(String.format("0x%x", number & 0x7f | 0x80));
                number >>= 7;
            }

            Collections.reverse(bs);
            encoded.addAll(bs);
        }

        return encoded;
    }

    List<String> decode(List<Long> bytes)
    {
        if ((bytes.get(bytes.size() - 1) & 0x80) != 0) {
            throw new IllegalArgumentException(
                "Invalid variable-length quantity encoding");
        }

        List<String> decoded = new ArrayList<String>();

        long number = 0L;
        for(Long bt: bytes)
        {
            number <<= 7;
            number += bt & 0x7f;
            if ((bt & 0x80) == 0) {
                decoded.add(String.format("0x%x", number));
                number = 0L;
            }
        }

        return decoded;
    }
}
