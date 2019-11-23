package StringAlgorithm;

import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName MyStrToInt
 * @Date 2019/11/16 11:04
 * @Version 1.0
 */


public class MyStrToInt {
    public static int myAtoi(String str){
        if(str==null)
            return 0;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        int len = 0;
        while(str.length() > len){
            if(str.charAt(len) == '-' || str.charAt(len) == '+') {
                flag = true;
                stack.push(str.charAt(len));
            } else if(Character.isDigit(str.charAt(len)))
            {
                flag = true;
            }
            if(flag && Character.isDigit(str.charAt(len))){
                stack.push(str.charAt(len));
            }
            len++;
        }
        while(stack.isEmpty())
            System.out.println(stack.pop());
        return 0;
    }

    public static void main(String[] args) {
        String str1 = "42";
        String str2 =  "dfa";
    }
}
