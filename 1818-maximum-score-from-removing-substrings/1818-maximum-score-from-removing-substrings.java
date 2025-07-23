class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x >= y) {
            return process(s, "ab", x, "ba", y);
        } else {
            return process(s, "ba", y, "ab", x);
        }
    }

    private int process(String s, String firstPair, int firstScore, String secondPair, int secondScore) {
        StringBuilder sb = new StringBuilder();
        int score = 0;
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == firstPair.charAt(0) && sb.charAt(sb.length() - 1) == firstPair.charAt(1)) {
                sb.setLength(sb.length() - 2);
                score += firstScore;
            }
        }

        StringBuilder finalSb = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            finalSb.append(c);
            if (finalSb.length() >= 2 && finalSb.charAt(finalSb.length() - 2) == secondPair.charAt(0) && finalSb.charAt(finalSb.length() - 1) == secondPair.charAt(1)) {
                finalSb.setLength(finalSb.length() - 2);
                score += secondScore;
            }
        }

        return score;
    }
}