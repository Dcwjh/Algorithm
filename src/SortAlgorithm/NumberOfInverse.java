package SortAlgorithm;

/**
 * @Description 逆数对问题左边序列比右边序列大的数对，左比右大。
 * @Author Jianhai Wang
 * @ClassName NumberOfInverse
 * @Date 2020/11/13 10:13
 * @Version 1.0
 */


public class NumberOfInverse {
    private static int function(int[] nums){
        if(nums == null || nums.length < 2)
            return 0;
        return mergerSort(nums, 0 , nums.length - 1);
    }

    private static int mergerSort(int[] nums, int left, int right){
        if(left == right)
            return 0;
        int mid = left + ((right - left)>>1);
        int numLeft = mergerSort(nums, left, mid);
        int numRight = mergerSort(nums, mid + 1, right);
        return numLeft + numRight + merge(nums, left, mid, right);
    }

    private static int merge(int[] nums, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int num = 0;
        int pHelp = 0;
        int pLeft = left;
        int pRight = mid + 1;
        while(pLeft <= mid && pRight <= right){
            //利用左子数组的有序性，减少比比较次数: 若左子数组pLeft的数值大于右子数组pRight的数组，则左子数组中pLeft 右边的位置都比pRight的位置大
            if(nums[pLeft] > nums[pRight]){
                num += (mid - pLeft + 1);
            }
            help[pHelp++] = nums[pLeft] < nums[right] ? nums[pLeft ++] : nums[pRight ++];
        }
        while(pLeft <= mid){
            help[pHelp++] = nums[pLeft++];
        }
        while(pRight <= right){
            help[pHelp++] = nums[pRight++];
        }

        for(int i = 0; i < help.length; i++){
            nums[left + i] = help[i];
        }
        return num;
    }
}
