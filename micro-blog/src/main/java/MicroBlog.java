class MicroBlog {
    public String truncate(String input) {
        final int length = input.length();
        int codePointCount = 0;
        StringBuilder result = new StringBuilder();
        for(int offset = 0; offset < length; ) {
            final int codePoint = input.codePointAt(offset);
            result.appendCodePoint(codePoint);
            ++codePointCount;
            if (codePointCount == 5) {
                break;
            }
            offset += Character.charCount(codePoint);
        }
        return result.toString();
    }
}
