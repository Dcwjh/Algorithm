package Leetcode;

import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName RemoveKdigits_402
 * @Date 12/2/2020 2:36 PM
 * @Version 1.0
 */


public class L402_RemoveKdigits {
     //递增栈，小的入栈，大的出栈
//    "1432219"  k = 3
//    bottom[1       ]top		1入
//    bottom[1 4     ]top		4入
//    bottom[1 3     ]top	4出	3入
//    bottom[1 2     ]top	3出	2入
//    bottom[1 2 2   ]top		2入
//    bottom[1 2 1   ]top	2出	1入	出栈满3个，停止出栈
//    bottom[1 2 1 9 ]top		9入
    public static String removeKdigits(String num, int k) {
            Stack<Character> s = new Stack();
            if(num.length() == k)
                return "0";
            char[] str = num.toCharArray();
            int i ;
            for( i = 0; i < str.length; i++){
                while(!s.isEmpty()&& s.peek() > str[i] && k > 0){
                    s.pop();
                    k--;
                }
                s.push(str[i]);
                if(s.size() == 1 && s.peek() == '0'){
                    s.pop();
                }
            }
            while(k > 0){
                s.pop();
                k--;
            }
            StringBuilder sb = new StringBuilder();
            while(!s.isEmpty()) {
                sb.append(s.pop());
            }
            String result = sb.reverse().toString();
            return result.length() == 0? "0":result;

    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1234567890",9));
    }
}
