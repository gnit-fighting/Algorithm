package Hot100.mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 括号生成
 */
public class _22 {
    StringBuilder sb = new StringBuilder();
    int lcnt = 0;
    int rcnt = 0;
    int N;
    Stack<Character> stack = new Stack<>();
    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        List<String> strings = new _22().generateParenthesis(3);

    }

    public List<String> generateParenthesis(int n) {
        N = n;
        backtracking(n * 2);
        return result;
    }

    public void backtracking(int n) {
        if (lcnt > N || lcnt > N) {
            return;
        }
        if (lcnt == N && rcnt == N && stack.isEmpty()) {
            result.add(new String(sb));
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                sb.append('(');
                lcnt++;
                stack.push('(');

                backtracking(n - 1);

                lcnt--;
                sb.deleteCharAt(sb.length() - 1);
                stack.pop();
            } else {
                if (!stack.isEmpty()) {
                    sb.append(')');
                    rcnt++;
                    stack.pop();

                    backtracking(n - 1);

                    rcnt--;
                    sb.deleteCharAt(sb.length() - 1);
                    stack.push('(');
                }
            }

        }
    }

}
