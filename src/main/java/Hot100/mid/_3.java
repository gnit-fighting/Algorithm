package Hot100.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复的最长子串
 */
public class _3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int max = 0;
        int i = 0;
        int j = 0;
        while (j < charArray.length && i <= j) {
            if (map.get(charArray[j]) == null || map.get(charArray[j]) == 0) {
                map.put(charArray[j], 1);
                max = max > (j - i + 1) ? max : (j - i + 1);
                j++;
            } else {
                while ( charArray[i] != charArray[j]) {
                    map.put(charArray[i], 0);
                    i++;
                }
                if (i != j && charArray[i] == charArray[j]) {
                    i++;

                }
                max = max > (j - i + 1) ? max : (j - i + 1);
                j++;
            }
        }
        return max;
    }
}
