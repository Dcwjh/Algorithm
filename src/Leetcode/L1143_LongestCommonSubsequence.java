package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1143_LongestCommonSubsequence
 * @Date 1/14/2021 10:50 AM
 * @Version 1.0
 */


public class L1143_LongestCommonSubsequence {

    //动态规划

//    动态规划算法做的就是穷举 + 剪枝，它俩天生一对儿。所以可以说只要涉及子序列问题，十有八九都需要动态规划来解决，往这方面考虑就对了。
   //https://leetcode-cn.com/problems/longest-common-subsequence/solution/dong-tai-gui-hua-zhi-zui-chang-gong-gong-zi-xu-lie/
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int len1 = text1.length();
        int len2 = text2.length();
        //留出空白，数组初始化不用自己写了。初始化状态就是自己本身。和头节点一样的道理

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j ++){
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public int longestCommonSubsequence1(String text1, String text2) {

        return dp1(text1, text2, 0,0);
    }

    //自顶向下，时间太长，没有剪枝
    private int dp2(String text1, String text2, int i, int j){
        if(i < 0 || j < 0)
            return 0;
        if(text1.charAt(i) == text1.charAt(j))
            return dp2(text1,text2,i - 1, j - 1) + 1;
        else
            return Math.max(dp2(text1, text2, i - 1, j),dp2(text1,text2,i,j - 1));

    }

    private int dp1(String text1, String text2, int i, int j){
        if(i == text1.length() || j == text2.length())
            return 0;
        if(text1.charAt(i) == text2.charAt(j))
            return dp1(text1, text2, i + 1, j + 1);
        else
            return Math.max(dp1(text1, text2, i + 1, j),dp1(text1,text2,i,j + 1));
    }

    public static void main(String[] args) {
        System.out.println(new L1143_LongestCommonSubsequence().longestCommonSubsequence1("pmjghexybyrgzczy",
            "hafcdqbgncrcbihkd"));
    }

}
