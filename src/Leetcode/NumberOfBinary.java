package Leetcode;

/**
 * @Description 华为面试题
 * @Author Jianhai Wang
 * @ClassName NumberOfBinary
 * @Date 2020/7/22 14:27
 * @Version 1.0
 */


public class NumberOfBinary {

    public static int function(int num) {
        int count = 0;
        while (num > 0) {
            if (((num % 2) & 1) == 1) {
                count++;
            }
            num /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(function(65534));
    }
}
