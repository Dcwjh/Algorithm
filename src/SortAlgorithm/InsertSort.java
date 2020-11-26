package SortAlgorithm;

import static utils.Swap.swap;

/**
 * @Description 插入排序
 * @Author Jianhai Wang
 * @ClassName InsertSort
 * @Date 2019/11/5 23:26
 * @Version 1.0
 */


public class InsertSort {
    //好的情况为：O（N）
    //一般情况：O（N^2）
    //和数据情况有关系

    /**
     *      算法思想：打牌的时候，插入手牌的思想，逐渐有序
     *          （1）i代表下一张牌是第几张牌，从1到数组长度（前i - 1代表手上牌的数目）
     *          （2）插牌：先从i-1位置开始找，若i-1牌位置大，则i-1和i位置交换，继续向前找合适的位置
     *                                      若i-1牌位置小，则i位置的值正好是自己
     * @param nums
     */
    public static void insertSort(int[] nums){
        if(nums == null || nums.length < 2)
            return;
        for(int i = 1; i < nums.length; i++){
            for(int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j-- )
                swap(nums, j, j+1);
        }
    }
}
