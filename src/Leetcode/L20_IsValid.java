package Leetcode;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L20_IsValid
 * @Date 12/14/2020 2:37 PM
 * @Version 1.0
 */


public class L20_IsValid {
    public boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for(char c : str){
            if(stack.isEmpty() ||  c=='(' || c=='[' || c=='{'){
                stack.push(c);
            } else if(c==')' && stack.peek()!='('){
                return false;
            } else if(c==']' && stack.peek()!='['){
                return false;
            } else if(c=='}' && stack.peek() != '{'){
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();

    }



    public boolean isValid2(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
    //官方网站
    public boolean isValid3(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
