package Leetcode;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName LengthOfWord
 * @Date 2019/12/22 9:36
 * @Version 1.0
 */


public class LengthOfLastWord_58 {
    public static int lengthOfLastWord(String s){
//        for(int i = 0; i < s.length(); i++){
//            if(Character.isLetter(s.charAt(i)))
//                break;
//            else if(s.charAt(i) == ' ')
//                continue;
//            else
//                return 0;
//        }

        //等价上面的功能
        s = s.trim();  //去掉开头和结尾字符串
//        String[] array = Pattern.compile(" ").split(s);
        String[] array = s.split(" ");
        return array[array.length - 1].length();
    }


    public static int method(String s){
        int start = 0;
        int end = 0;
        if(!s.contains(" "))
            return s.length();
        for(int i = s.length() - 1; i >= 0; i--){
            if(Character.isLetter(s.charAt(i))) {
                if(start ==0)
                    start = i + 1;
            }else{
                end = i + 1;
                break;
            }
        }
        return Math.max(start - end, 0);
    }

    public static void main(String[] args) {
        System.out.println(method("a"));
    }
}
