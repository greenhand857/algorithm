package LeetCodeHot100;

import java.util.Stack;

public class _020_ValidKuoHao {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     */
    // 算法思路：准备一个栈，遍历字符数组，碰到左括号时，向栈中压入对应的右括号
    // 如果当前遍历字符，不是以上三种情况，即是右括号，则先判断当前栈中是否为空，
    // 或者 当前遍历字符与栈中弹出字符不相等，则返回false
    // 遍历结束时，栈为空，则返回true
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

}
