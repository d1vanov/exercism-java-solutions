class RnaTranscription {

    String transcribe(String dnaStrand) {
        StringBuilder rna = new StringBuilder();
        for(int i = 0; i < dnaStrand.length(); ++i) {
            char c = dnaStrand.charAt(i);
            switch(c) {
                case 'A':
                    rna.append('U');
                    break;
                case 'T':
                    rna.append('A');
                    break;
                case 'C':
                    rna.append('G');
                    break;
                case 'G':
                    rna.append('C');
                    break;
                default:
                    throw new IllegalArgumentException("Bad input DNA: " + c);
            }
        }

        return rna.toString();
    }

}
