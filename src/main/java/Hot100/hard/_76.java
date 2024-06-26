package Hot100.hard;

import java.io.CharConversionException;
import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 */
public class _76 {
    public static void main(String[] args) {
        String s = "bbaa";
        String t = "aba";
        String s1 = new _76().minWindow0(s, t);
    }

    public String minWindow(String s, String t) {
        int slen = s.length();
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        int less = 0;
        for (int i = 0; i < t.length(); i++) {
            if (cntT[t.charAt(i)]++ == 0) {
                less++;
            }
        }
        int ansl = -1;
        int ansr = slen;
        int l = 0;
        int r = 0;

        for (r = 0; r < slen; r++) {
            if (++cntS[s.charAt(r)] == cntT[s.charAt(r)]) {
                less--;
            }

            while (less == 0) {
                if (r - l < ansr - ansl) {
                    ansl = l;
                    ansr = r;
                }

                if (cntS[s.charAt(l)]-- == cntT[s.charAt(l)]) {
                    less++;
                }
                l++;
            }
        }
        return ansl < 0 ? "" : s.substring(ansl, ansr + 1);
    }

    public String minWindow1(String s, String t) {
        int slen = s.length();
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        for (int i = 0; i < t.length(); i++) {
            cntT[t.charAt(i)]++;
        }
        int ansl = -1;
        int ansr = -1;
        int l = 0;
        int r = 0;

        for (r = 0; r < slen; r++) {
            cntS[s.charAt(r)]++;

            while (isCovered(cntS, cntT)) {
                if (r - l < ansr - ansl) {
                    ansl = l;
                    ansr = r;
                }
                cntT[s.charAt(l)]--;
                l++;
            }
        }


        return ansl < 0 ? "" : s.substring(ansl, ansr + 1);
    }

    public boolean isCovered(int[] cntS, int[] cntT) {
        //如果对于每个字母，都有 cnts >= cntT，则子串蕴含 T
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }


    public String minWindow0(String s, String t) {
        //滑动窗口？[写了超级久。。。思路应该没问题，但是利口最后几个用例超时]【几个方法写的太冗余了，看灵神的优雅代码！！】
        char[] sCharArray = s.toCharArray();
        char[] tcharArray = t.toCharArray();
        if (s.length() < t.length()) {
            return "";
        }
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return t;
            }
        }

        Map<Character, Integer> tmap = new HashMap<>();
        for (char c : tcharArray) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> tfind = new HashMap<>();
        for (char c : tcharArray) {
            tfind.put(c, 0);
        }


        int minlen = Integer.MAX_VALUE;
        int ansl = -1;
        int ansr = -1;

        int l = 0;//窗口左边界
        int r = 0;//窗口右边界
        while (l <= r && r < s.length()) {
            char c = sCharArray[r];
            if (t.contains(c + "")) {
                tfind.put(c, tfind.get(c) + 1);

                while (findAll(tfind, tmap, tcharArray)) {
                    if ((r - l + 1) < minlen) {
                        minlen = r - l + 1;
                        ansl = l;
                        ansr = r;
                    }

                    if (tfind.containsKey(sCharArray[l])) {
                        tfind.put(sCharArray[l], tfind.get(sCharArray[l]) - 1);
                    }

                    l++;
                }

            }
            r++;
        }

        if (ansl != -1 && ansr != -1) {
            return s.substring(ansl, ansr + 1);
        }
        return "";
    }

    public boolean findAll(Map<Character, Integer> finds, Map<Character, Integer> tmap, char[] tchararray) {
        for (char c : tchararray) {
            if (finds.get(c) < tmap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
