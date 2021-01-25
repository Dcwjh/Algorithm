package NIUKE;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC52
 * @Date 1/15/2021 5:11 PM
 * @Version 1.0
 */


public class NC52 {

    public boolean isValid (String s) {
        // write code here
        HashMap<Character, Character> map = new HashMap<>();

        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()|| map.get(s.charAt(i)) != stack.peek()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty()?true:false;
    }
}
