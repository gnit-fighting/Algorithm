package Hot100.mid;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _131_1 {
    List<List<String>> result;
    Deque<String> path;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(s,0);
        return result;
    }
    public void backtracking(String s,int startIdx){
        if(startIdx >= s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i < s.length(); i++) {
            String substring = s.substring(startIdx, i + 1);
            if (isHuiWen(substring)) {
                path.add(substring);
                backtracking(s,i+1);
                path.removeLast();
            }
        }
    }
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
