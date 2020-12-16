package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L125_IsPalindrome
 * @Date 12/16/2020 3:00 PM
 * @Version 1.0
 */


public class L125_IsPalindrome {
    /**
     * @version 1.0
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if(s.length() ==0) return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();i ++){
            char ch = s.charAt(i);
            if((ch >='0'&& ch<='9')||(ch>='a'&&ch<='z')){
                sb.append(ch);
            }
        }
        char[] str  = sb.toString().toCharArray();
        int left = 0;
        int right = str.length - 1;
        while(left < right){
            if(str[left] != str[right])
                return false;
            left ++;
            right--;
        }
        return true;
    }


    /**
     * @version 2.0
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        char[] chs = s.toCharArray();
        int start = 0;
        int end = chs.length-1;
        while (start <= end) {
            if(!Character.isDigit(chs[start]) && !Character.isLetter(chs[start]))
                start++;
            else if(!Character.isDigit(chs[end]) && !Character.isLetter(chs[end]))
                end--;
            else if(chs[start] != chs[end])
                return  false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }


    /**
     * @version 3.0
     */

    public boolean isPalindrome3(String s) {
        if (s == null || s.length() == 0)
            return true;
        String str = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(str);
        return sb.toString().equals(sb.reverse().toString());
    }
}
