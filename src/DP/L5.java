package DP;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L5
 * @Date 2021/7/5 18:30
 * @Version 1.0
 */


public class L5 {
    public  String longestPalindrome(String s){
        if(s == null || s.length() == 0) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        int start = 0;
        //先是长度然后才能遍历，要不然就先初始化。否则就先长度，在遍历
        for(int len = 1; len <= n; len++){
            for(int i = 0; i + len <= n; i ++){
                if(len == 1){
                    dp[i][i] = true;
                } else if(len == 2 && s.charAt(i) == s.charAt(i + 1)){
                    dp[i][i + len - 1] = true;
                    if(max < len){
                        start = i;
                        max = len;
                    }
                }else if(dp[i + 1][len + i - 2] && s.charAt(i) == s.charAt(i + len - 1)){
                    dp[i][i + len - 1] = true;
                    if(max < len){
                        max = len;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }


    //把j直接当作最大长度考虑
    public  String longestPalindrome1(String s){

        if(s == null || s.length() == 0) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        int start = 0;
        //将J当成最大长度.  长度从前往后推
        for(int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                //先判断相不相等
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i < 3) //如果小于两个字符
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                if(dp[i][j] && max < j - i + 1){
                    start = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        int a = 50000;
        int n = 20;
        double t = 0;
        String s = new String();
        for(int i = 0; i <= 20; i++){
            t = t * 1.17 + 5;
        }
        System.out.println(t);
        int [] nums = {1,2,3};
        int[] snums = nums.clone();
        for(int i = 0; i < snums.length; i++)
            System.out.print(snums[i] + " ");
    }
}
