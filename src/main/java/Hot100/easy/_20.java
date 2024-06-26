package Hot100.easy;

import java.util.Stack;

/**
 * 有效的括号
 */
public class _20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            //左括号的情况
            if (charArray[i] == '(') {
                stack.push(')');
                continue;
            }
            if (charArray[i] == '[') {
                stack.push(']');
                continue;
            }
            if (charArray[i] == '{') {
                stack.push('}');
                continue;
            }
            //右括号的情况
            if(stack.isEmpty()){
                return false;
            }
            Character pop = stack.pop();
            if (pop != charArray[i]) {
                return false;
            }


        }

        return stack.isEmpty();
    }
}
