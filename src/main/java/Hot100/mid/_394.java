package Hot100.mid;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 字符串解码
 */
public class _394 {
    public static void main(String[] args) {
        String s = new _394().decodeString("3[a2[bc]de]");
    }

    public String decodeString(String s) {
        class Node {
            int multi;
            StringBuilder last_res;

            Node(int multi, StringBuilder last_res) {
                this.multi = multi;
                this.last_res = last_res;
            }
        }

        StringBuilder res = new StringBuilder();
        int multi = 0;
        Deque<Node> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; ) {
            char c = charArray[i];
            // c 为数字
            if (Character.isDigit(c)) {
                int k = i + 1;
                while (Character.isDigit(charArray[k])) {
                    k++;
                }
                Integer i1 = new Integer(new String(charArray, i, k - i));
                multi = i1;
                i = k;
            }
            // c为字母
            if ('a' <= c && c <= 'z') {
                res.append(c);
                i++;
            }
            // c 为‘【’
            if (c == '[') {
                stack.push(new Node(multi, new StringBuilder(res)));
                multi = 0;
                res = new StringBuilder();
                i++;
            }
            if (c == ']') {
                Node pop = stack.pop();
                String appendthis = new String(res);
                for (int j = 0; j < pop.multi - 1; j++) {
                    res.append(appendthis);
                }
                res = pop.last_res.append(res);
                i++;
            }

        }
        return new String(res);
    }


}
