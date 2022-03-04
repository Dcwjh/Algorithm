package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L5_LongestPalindrome
 * @Date 2021/4/2 17:18
 * @Version 1.0
 */


public class L5_LongestPalindrome {
    public  String longestPalindrome(String s){
        if(s == null || s.length() < 2)
            return s;
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        int begin = 0;
        int max = 1;
        for(int j = 1; j < s.length(); j ++){
            for(int i = 0; i < j; i++){
                if(str[i] == str[j]){
                    if(j - i < 3) //两个字符
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                if(dp[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}
