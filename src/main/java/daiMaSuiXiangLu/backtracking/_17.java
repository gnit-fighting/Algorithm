package daiMaSuiXiangLu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _17 {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String[] record = new String[10];

    public List<String> letterCombinations(String digits) {
        //初识化 record
        record[2] = "abc";
        record[3] = "def";
        record[4] = "ghi";
        record[5] = "jkl";
        record[6] = "mno";
        record[7] = "pqrs";
        record[8] = "tuv";
        record[9] = "wxyz";


        if (digits == null || digits.length() == 0) {
            return result;

        }
        backtracking(0, digits);
        return result;
    }

    public void backtracking(int index, String digits) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < record[digits.charAt(index) - '0'].length(); i++) {
            char c = record[digits.charAt(index) - '0'].charAt(i);
            sb.append(c);
            backtracking(index + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
