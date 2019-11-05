package utils;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Swap
 * @Date 2019/11/5 22:37
 * @Version 1.0
 */


public class Swap {
    //采用位运算，不需要额外空间
    public static void new_swap(int [] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
