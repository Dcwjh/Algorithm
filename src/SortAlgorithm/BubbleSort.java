package SortAlgorithm;

import static utils.Swap.swap;

/**
 * @Description 冒泡排序
 * @Author Jianhai Wang
 * @ClassName BubbleSort
 * @Date 2019/11/5 23:29
 * @Version 1.0
 */


public class BubbleSort {
    //时间复杂度严格为O（N^2）
    public static void bubbleSort(int [] nums){
        if(nums == null || nums.length < 2)
            return;

        for(int end = nums.length - 1; end >= 0; end -- ){
            for(int i = 0; i < end; i++){
                if(nums[i] > nums[i + 1])
                    swap(nums, i , i+1);
            }
        }
    }
}
