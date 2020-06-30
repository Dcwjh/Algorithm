package 剑指offer;

/**
 * @Description n个骰子的点数
 * @Address https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 * @Author Jianhai Wang
 * @ClassName Interview60
 * @Date 2020/6/30 17:37
 * @Version 1.0
 */


public class Interview60 {
    public double[] twoSum(int n) {
        int [][]dp = new int[n+1][6*n+1];
        //边界条件
        for(int s=1;s<=6;s++)dp[1][s]=1;


        for(int i=2;i<=n;i++){
            //和的个数
            for(int s=i;s<=6*i;s++){
                //求dp[i][s]   如果i >= s基本不可能，s必须要大于i, i是掷色子的次数，s为其和
                for(int d=1;d<=6;d++){
                    if(s-d<i-1)break;//   前面不用改都是0
                    dp[i][s]+=dp[i-1][s-d];
                }
            }
        }
        double total = Math.pow((double)6,(double)n);
        double[] ans = new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            ans[i-n]=((double)dp[n][i])/total; //前面没数，后面有数
        }
        return ans;
    }
}
