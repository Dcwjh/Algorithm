package 剑指offer;

/**
 * @Description 数值的整数次方
 * @Address https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @Author Jianhai Wang
 * @ClassName Interview16
 * @Date 2020/6/30 19:49
 * @Version 1.0
 */


public class Interview16 {

    //方法：分治：
    // 根据二分推导，可通过循环 x = x^2操作，每次把幂从 n 降至 n//2 ，直至将幂降为 0 ；
    //设 res=1 ，则初始状态 x^n = x^n * res 。在循环二分时，每当 n 为奇数时，将多出的一项 x 乘入 res ，则最终可化至 x^n = x^0 * res = res ，返回 resres 即可。
    public double myPow(double x, int n) {
        if( x== 0) return 0;//考虑特殊情况
        if(n == 0) return 1;
        if(n == 1) return x;
        long b = n;  //b是指数
        double res = 1.0;
        if(b < 0){  //当b是复数时
            x = 1/x;
            b = -b;
        }
        while(b > 0){
            if((b&1) == 1) res*= x;  //从最低位开始
            x *= x;
            b >>= 1;

        }
        return res;
    }
}
