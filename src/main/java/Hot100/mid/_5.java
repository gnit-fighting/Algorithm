package Hot100.mid;

/*
最长回文子串
 */
public class _5 {
    public static void main(String[] args) {
        String s = "aaaa";
        String s1 = new _5().longestPalindrome(s);
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int maxlen = 1;
        int ansl = 0;
        int ansr = 0;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j - 1; i++) {
                if (charArray[i] == charArray[j] && j == i + 1) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxlen) {
                        maxlen = j - i + 1;
                        ansl = i;
                        ansr = j;
                    }
                }
                if (charArray[i] == charArray[j] && i + 1 <= j - 1 && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxlen) {
                        maxlen = j - i + 1;
                        ansl = i;
                        ansr = j;
                    }
                }

            }
        }
        return s.substring(ansl,ansr+1);
    }
}
