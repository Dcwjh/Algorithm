package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName TrailingZeroes_172
 * @Date 12/9/2020 4:59 PM
 * @Version 1.0
 */


public class L172_TrailingZeroes {
    //统计5的个数，因为2的个数比5多，只要有一个5就会出现一个0
    public static  int trailingZeroes(int n) {
        int ans = 0;
        while(n > 0){
            ans += n/5;
            n /=5;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
    }
}
