package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1004最大连续1的个数III
 * @Date 2021/8/6 17:31
 * @Version 1.0
 */


public class L1004最大连续1的个数III {
    //dp:https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/san-chong-jie-fa-cong-dong-tai-gui-hua-d-gxks/
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        //
        int[][] f = new int[2][k + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (nums[i - 1] == 1) {
                    f[i & 1][j] = f[(i - 1) & 1][j] + 1;
                } else {
                    f[i & 1][j] = j == 0 ? 0 : f[(i - 1) & 1][j - 1] + 1;
                }
                ans = Math.max(ans, f[i & 1][j]);
            }
        }
        return ans;
    }

    public int longestOnes1(int[] nums, int k) {

        int left = 0;
        int res = 0;
        int count = 0;
        //固定右边界
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 1 ){
                res = Math.max(res, right - left + 1);
            } else{
                count++;
                while(count > k) {
                    if (nums[left] == 0) {
                        count--;
                    }
                    left++;
                }
            }
        }
        return res;
    }

    public int longestOnes2(int[] nums, int k) {

        int left = 0;
        int res = 0;
        int count = 0;
        //固定右边界
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 1 ){
                res = Math.max(res, right - left + 1);
            } else{
                count++;
                while(count > k) {
                    if (nums[left] == 0) {
                        count--;
                    }
                    left++;
                }
            }
        }
        return res;
    }


}
