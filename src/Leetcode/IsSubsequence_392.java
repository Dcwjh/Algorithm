package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName IsSubsequence_392
 * @Date 11/30/2020 3:10 PM
 * @Version 1.0
 */


public class IsSubsequence_392 {
    public static boolean isSubsequence(String s, String t) {
        int p  = 0;
        for(int i = 0; i < s.length(); i++){
            if(p == t.length())
                return true;
            if(t.charAt(p) == s.charAt(i)){
                p++;
            }
        }
        return p == t.length()?true:false;
    }


    //双指针
    public static boolean fun(String s, String t){
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("ahbgdc","abc"));
    }
}
