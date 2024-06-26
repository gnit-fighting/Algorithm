package Hot100.mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 单词拆分
 */
public class _139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean b = new _139().wordBreak0(s, wordDict);

    }

    public boolean wordBreak0(String s, List<String> wordDict) {
        //完全背包
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int j = 1; j <= s.length(); j++) { //先遍历背包
            for (int i = 0; i < wordDict.size(); i++) { //再遍历物品
                String word = wordDict.get(i);
                if (word.length() > s.length()) {
                    continue;
                }
                if (!dp[word.length()]) {
                    if (word.equals(s.substring(0, word.length()))) {
                        dp[word.length()] = true;
                    }
                }
                if (j >= word.length() && dp[j - word.length()]) {
                    if (s.substring(j - word.length(), j).equals(word)) {
                        dp[j] = true;
                    }
                }
                if (dp[s.length()]) {
                    return true;
                }
            }

        }
        return dp[s.length()];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {//先遍历背包【求排列】
            for (int j = 0; j < i; j++) { //再遍历物品（这里不是说严格去遍历物品数组，通过分割子串，判断分出来的单词在不在字典而已，这样比上面的简洁）
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
