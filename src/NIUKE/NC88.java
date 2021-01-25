package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC88
 * @Date 1/12/2021 3:57 PM
 * @Version 1.0
 */
//给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。

public class NC88 {
    public int findKth(int[] a, int n, int K) {
        return quick(a, 0, n - 1, K);
    }

    private int quick(int[] nums, int left, int right, int K){
        swap(nums, right, left + (int)Math.random()*(right - left + 1)); //提高随机性，减少复杂度。
        int pivot = partion(nums, left, right);
        if(pivot == K - 1)
            return nums[pivot];
        else if(pivot < K - 1){
            return quick(nums,pivot + 1, right,K );
        } else{
            return quick(nums, left, pivot - 1,K);
        }

    }

    private int partion(int[] nums, int left, int right){
        int pivot = right;
        right --;
        while(left < right){
            //左小右大
            if(nums[left] < nums[pivot] && nums[right] > nums[pivot])
                swap(nums, left++, right--);
            while(left < right && nums[left] >= nums[pivot]) left++;
            while(left < right && nums[right] <= nums[pivot]) right--;
        }
        //终止条件left==right,但是此时不知道和pivot的关系
        if(nums[left] > nums[pivot]){
            swap(nums, ++left , pivot);//向后移动以为即可
        } else
            swap(nums, left, pivot);
        return left; //最终交换的位置就是要返回的值
    }


    //第二种写法
    private int partion2(int[] nums, int left, int right){
        int pivot = right;
        right --;
        while(left <= right){
            //左小右大
            if(nums[left] < nums[pivot] && nums[right] > nums[pivot])
                swap(nums, left++, right--);
            while(left <= right && nums[left] >= nums[pivot]) left++;
            while(left <= right && nums[right] <= nums[pivot]) right--;
        }
        //此刻left > right, 由于比right小的数都在右边
        swap(nums, left, pivot);
        return left; //最终交换的位置就是要返回的值
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
