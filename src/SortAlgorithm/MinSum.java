package SortAlgorithm;

/**
 * @Description 小和问题：在一个数组中，每一个数左边比当前数小的数累加起来，叫这个数组的小和
 * @Author Jianhai Wang
 * @ClassName MinSum
 * @Date 2020/11/13 9:33
 * @Version 1.0
 */


public class MinSum {
    private static int minSum(int[] nums) {
        if(nums.length < 2)
            return 0;
        return mergeSort(nums, 0, nums.length - 1);

    }

    private static int mergeSort(int[] nums, int left, int right){
        if(left == right)
            return 0;
        int mid = left + ((right - left) >> 1);
        int sumLeft = mergeSort(nums, left, mid);
        int sumRight = mergeSort(nums, mid + 1, right);
        return sumLeft + sumRight + merge(nums, left, mid, right);
    }

    private static int merge(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int pHelp = 0;
        int sum = 0;
        int pLeft = left;
        int pRight = mid + 1;
        //利用归并排序解决算法问题，主要就在合并过程中求解
        while(pLeft <= mid && pRight <= right){
            if(nums[pLeft] < nums[pRight]) {
                //合并过程中（这个是思想精髓）：解不出来问题往往在这个地方出错。利用右子数组的有序性
                //默认左子数组和右子数组默认有序，若此时pLeft位置小于pRight位置，则pRight右边的位置都比pLeft位置数大（因为pRight所在数组有序）
                sum += nums[pLeft] * (right - pRight + 1);
            }
            help[pHelp ++] = nums[pHelp] < nums[pRight] ? nums[pHelp++] : nums[pRight++];
        }
        while(pLeft <= mid){
            help[pHelp ++] = nums[pLeft++];
        }
        while(pRight <= right){
            help[pHelp++] = nums[pRight++];
        }
        for(int i = 0; i < help.length; i++){
            nums[left + i] = help[i];
        }
        return sum;
    }
}
