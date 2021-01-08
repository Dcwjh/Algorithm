package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L189_Rotate
 * @Date 1/8/2021 8:41 AM
 * @Version 1.0
 */


public class L189_Rotate {
    //方法一：正向思维
    public void rotate(int[] nums, int k) {
        if(nums.length < 2 || k == 0) return;
        int conut = 0;
        int i = 0;
        int pre = nums[0];
        int start = 0;
        int temp = 0;
        while(conut < nums.length) {
            temp =  nums[(i+k)%nums.length];
            nums[(i+k)%nums.length] = pre;
            pre = temp;
            i = (i+k)%nums.length;
            if(i == start  && i < nums.length - 1){
                i++;
                start++;
                pre = nums[i];
            }
            conut++;
        }

    }

    //方法二：逆向思维。思想很重要
    public void rotate1(int[] nums, int k) {
        if(nums.length < 2 || k == 0) return;
        int n = nums.length;
        reverse(nums,0, n-1);
        reverse(nums, 0, k % n - 1);
        reverse(nums, k%n, n - 1);
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){   //不能取等于是因为两个数不能相等，相等就变成0了
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        new L189_Rotate().rotate1(new int[]{1,2,3,4,5,6,7},3);
    }
}
