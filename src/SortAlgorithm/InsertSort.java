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
    public static void insertSort(int[] nums){
        if(nums == null || nums.length < 2)
            return;
        for(int i = 1; i < nums.length; i++){
            for(int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j-- )
                swap(nums, j, j+1);
        }
    }
}
