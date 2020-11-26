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

    /**
     * 算法思想：算法代码不重要，重要的的思想，有思想才能写出好的代码
     *      （1）遍历长度从数组长度length依次减少1直到0
     *      （2）从前往后遍历上述长度（相邻依次比较），从该长度中选出符合条件的数字，放在数组最后面。
     * @param nums
     */
    public static void bubbleSort(int [] nums){
        if(nums == null || nums.length < 2)
            return;

        for(int end = nums.length - 1; end >= 0; end -- ){  //end代表每次i遍历的长度，长度从后往前减少
            for(int i = 0; i < end; i++){   //从前往后遍历，每次选出符合条件的数字放在end位置（也就是最后的位置）
                if(nums[i] > nums[i + 1])
                    swap(nums, i , i+1);
            }
        }
    }
}
