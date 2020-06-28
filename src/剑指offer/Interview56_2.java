package 剑指offer;

/**
 * @Description 数组中唯一出现一次的数字
 * @Author Jianhai Wang
 * @ClassName Interview56_2
 * @Date 2020/6/28 15:49
 * @Version 1.0
 */


public class Interview56_2 {
    public int singleNumber(int[] nums) {
        //低位到高位开始统计
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;//在最低为进行统计
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;  //数在扩大
            res |= counts[31 - i] % m; //一开始是最高位
        }
        return res;
    }
}
