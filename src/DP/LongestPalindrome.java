package DP;

/**
 * @Description 最长回文子序列
 * @Author Jianhai Wang
 * @ClassName LongestPalindrome
 * @Date 2019/11/9 11:16
 * @Version 1.0
 */


public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        String longestStr = s.substring(0,1);
        boolean [][] dp = new boolean[s.length()][s.length()];
        for(int end = 1; end < s.length(); end++) //尾坐标
            for(int start = 0; start < end; start ++) {  //头坐标
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                    print(dp);
                    if (dp[start][end] && end - start + 1 > longestStr.length()) {
                        longestStr = s.substring(start, end + 1);
                    }
                }
            }
        return longestStr;
    }

    public static String longestPalindrome2(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                print(dp);
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1
                if (dp[i][j] &&  j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


    public static void print(boolean [][] dp) {
        System.out.println("============start=====================");
        for(int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j])
                    System.out.print("T ");
                else
                    System.out.print("F ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static String longestPalindrome3(String s) {
        if(s.length() < 2)
            return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        String longestStr = "";
        for(int len = 1; len <= s.length(); len++) {  //字串长度, 遍历所有字串长度
            for(int start = 0; start < s.length(); start++){
                int end = start + len - 1;  //从字符串个数为1开始更新
                if(end >= s.length())  //end下标越界，停止该层循环
                    break;
                print(dp);
                dp[start][end] = (len == 1 || len == 2 || dp[start + 1] [end - 1] ) && s.charAt(start) == s.charAt(end);  //因为有这个&&，所有长度为1的字符串需要更新
                if(dp[start][end])
                    longestStr = s.substring(start, end + 1);
            }
        }
        return longestStr;
    }


    public  static String longestPalindrome7(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                print1(P);
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void print1(boolean[] dp){
        for(int i = 0; i < dp.length; i++){

            if(dp[i])
                System.out.print("T ");
            else
                System.out.print("F ");

        }
        System.out.println();

    }

    public static void main(String[] args) {
        String a = "abac";
        System.out.println(longestPalindrome7(a));

    }
}
