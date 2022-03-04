package SortAlgorithm;

import static utils.Swap.swap;

/**
 * @Description 基于荷兰国旗问题的快速排序算法
 * @Author Jianhai Wang
 * @ClassName NewQuickSort
 * @Date 2019/11/5 23:03
 * @Version 1.0
 */

public class NewQuickSort {

    public static void newQuickSort(int[] nums){
        if(nums == null || nums.length == 0)
            return;
        newQuickSort1(nums, 0, nums.length - 1);
    }

    public static void newQuickSort1(int[] nums, int left, int right){
        if(left < right){
            swap(nums, left + (int)(Math.random() *(right - left + 1)), right);
            int[] p = partition(nums, left, right);
            newQuickSort1(nums, left, p[0] - 1);
            newQuickSort1(nums, p[1] + 1, right);
        }
    }

    //基准数据不能动，等到最后找到合适的位置交换

    public static int[] partition(int[] nums, int left, int right){
        int less = left - 1; //less 是小于基于比教的数 0~less
        int more = right;  //最后一个数就是基于比较的数
        int num = nums[right]; //基准

        int index = left;
        while(index < more){  //left 作为游标
            if(nums[index] < num){
                swap(nums, ++less, index++);
            } else if(nums[index] > num){
                swap(nums, --more, index);  //more指向的是不确定的数字，交换后index不能++
            } else{
                index++;
            }
        }
        //more没有比较
        swap(nums, more, right); //交换一个大于num的数 more 就是大于num的数，nums[right]是基准，需要交换找一个大于num的数，more
        return new int[]{ less + 1, more};  //此时的more 就是num, less + 1也是num
    }







    private int partion3(int[] nums, int left, int right){
        int pivot = right;
        right --;
        while(left < right){
            //左小右大
            if(nums[left] < nums[pivot] && nums[right] > nums[pivot])
                swap(nums, left++, right--);
            while(left < right && nums[left] >= nums[pivot]) left++; //找到大于num的数
            while(left < right && nums[right] <= nums[pivot]) right--;//找到小于的数交换
        }


        //终止条件left==right,但是此时不知道和pivot的关系
        if(nums[left] > nums[pivot]){
            swap(nums, ++left , pivot);
        } else
            swap(nums, pivot, left);
        return left;
    }





















    public static int[] partition2(int[] nums, int left, int right){
        int less = left - 1;
        int more = right;
        int num = nums[right];
        while(left < more){
            if(nums[left] < num){
                swap(nums, ++less, left++);
            } else if(nums[left] > num){
                swap(nums, --more, left);
            } else{
                left++;
            }
        }
        swap(nums, more, right);
        return new int[]{less + 1, more};
    }
}
