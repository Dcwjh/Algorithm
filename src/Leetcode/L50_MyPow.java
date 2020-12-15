package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName MyPow_50
 * @Date 12/9/2020 5:18 PM
 * @Version 1.0
 */


public class L50_MyPow {
    public double myPow(double x, int n) {
        double ans = 0;
        for(int i = 0; i < n; i++){
            ans *= x;
        }
        return ans;
    }
}
