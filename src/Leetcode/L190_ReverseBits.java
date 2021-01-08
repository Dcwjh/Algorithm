package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L190_ReverseBits
 * @Date 12/23/2020 4:56 PM
 * @Version 1.0
 */


public class L190_ReverseBits {

    //面试开始时的一个热身问题。重点是测试一个人对数据类型和位操作的基本知识。

    //检索整数 n 中最右边的位，可以应用模运算（即 n%2）或与运算（即 n &1）  最右端也就是低位
    public int reverseBits(int n) {

        int ans = 0;
        int power = 31;
        while(power >= 0) {  //就算不移动也要在进行一次
            ans += (n & 1) << power;
            n = n >> 1;
            power--;
        }
        return ans;
    }
}
