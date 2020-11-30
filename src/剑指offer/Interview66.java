package 剑指offer;


/**
 * @Description 构建乘积数组
 * @Address https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * @Author Jianhai Wang
 * @ClassName Interview66
 * @Date 2020/6/29 12:16
 * @Version 1.0
 */


public class Interview66 {
    public static int[] constructArr(int[] a) {
        if(a == null || a.length == 0)
            return null;
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1]; //b[i]前置位乘积
        }
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];  //保留后置位乘积
            b[i] *= tmp;  // 前乘以后
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        System.out.println(constructArr(a));
    }
}
