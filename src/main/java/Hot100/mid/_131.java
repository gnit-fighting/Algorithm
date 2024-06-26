package Hot100.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分割回文串
 */
public class _131 {
    List<List<String>> result;
    List<String> path;
    int len;

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> partition = new _131().partition(s);
    }

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        len = s.length();
        backtracking(s, 0);
        if (isHuiWen(s)) {
            result.add(Arrays.asList(s));
        }
        return result;

    }

    public void backtracking(String s, int idx) {
        if (s.length() == 1) {
            path.add(s);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        if (idx >= s.length() - 1) {
            if (isHuiWen(s)) {
                path.add(s);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        //在此分割点切分
        String substring = s.substring(0, idx + 1);
        if (isHuiWen(substring)) {
            path.add(substring);
            //递归
            String nexts = s.substring(idx + 1);
            backtracking(nexts, 0);
            //回溯
            path.remove(path.size() - 1);
        }
        //切割点不切的情况
        //考察下一个切割点
        backtracking(s, idx + 1);
    }

    //判断回文串
    public boolean isHuiWen(String s) {
        char[] charArray = s.toCharArray();
        int l = 0;
        int r = charArray.length - 1;
        while (l <= r) {
            if (charArray[l] != charArray[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
