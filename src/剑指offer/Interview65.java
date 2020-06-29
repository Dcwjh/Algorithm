package 剑指offer;

/**
 * @Description 用位运算做加法
 * @Address https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * @Author Jianhai Wang
 * @ClassName Interview65
 * @Date 2020/6/29 12:06
 * @Version 1.0
 */




public class Interview65 {
    /**
     *
     * 主要考发散思维：
     * 交换两个值不使用新变量
     *
     * 基于加减法
     * a = a + b;
     * b = a - b;
     * a = a - b;
     *
     * 基于位运算
     * a = a ^ b;
     * b = a ^ b;
     * a = a ^ b;
     */
    public int add(int a, int b) {
        while(b!=0){
            int c = (a&b) <<1;
            a = a^b;
            b = c;
        }
        return a;
    }
}
