package Hot100.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 找出所有字母异位词
 */
public class _438 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] pc = p.toCharArray();
        Arrays.sort(pc);
        String s2 = new String(pc);
        char[] sc = s.toCharArray();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= sc.length - pc.length; i++) {
            //当前要处理的子串
            String subString = new String(sc, i, pc.length);
            char[] subc = subString.toCharArray();
            Arrays.sort(subc);
            String s1 = new String(subc);

            if (s1.equals(s2)) {
                result.add(i);
            }


        }
        return result;


    }
}
