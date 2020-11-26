package utils;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName GetMax
 * @Date 2020/11/12 10:50
 * @Version 1.0
 */


public class GetMax {

    public int getMax(int[] nums, int L, int R){
        if(0 > L || 0 > R || L > nums.length -1 || R > nums.length - 1 || L > R){
            System.out.println("输入不合法");
            return Integer.MIN_VALUE;
        }
        if(L == R)
            return nums[L];
        int mid = L + (R - L ) /2;
        int maxLeft = getMax(nums, L, mid);
        int maxRight = getMax(nums, mid + 1, R);
        return Math.max(maxLeft, maxRight);
    }
}
