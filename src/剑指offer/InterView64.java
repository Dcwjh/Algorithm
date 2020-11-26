package 剑指offer;

/**
 * @Description 求1+2+…+n
 * @Address https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @Author Jianhai Wang
 * @ClassName InterView64
 * @Date 2020/6/29 11:56
 * @Version 1.0
 */


public class InterView64 {
    public static int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(100));
    }
}
