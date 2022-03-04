package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L209_MinSubArrayLen
 * @Date 12/21/2020 5:22 PM
 * @Version 1.0
 */


public class L209_MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int count = nums.length + 1;
        int sum = 0;
        //满足其和 ≥ s 的长度最小的 连续 子数组.小于s，右指针向右移动，大于s,左指针向左移动
        while(end < nums.length){
            if(sum < s){
                sum += nums[end];
                end++;
            }
            while(sum >= s){  //若满足条件则左指针一直向左移动
                count = Math.min(count, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return count > nums.length? 0 : count;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int[] help = new int[nums.length + 1];
        for(int i = 1; i < nums.length + 1; i++) {  //help[i] 是nums[i - 1]之前得和
            if(nums[i- 1] == target){
                return 1;
            }
            help[i] = nums[i - 1] + help[i - 1];
        }
        for(int i = 0; i < help.length; i++)
            System.out.print(help[i] + " ");
        System.out.println();
        int count = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length + 1; i++){
            int s = target + help[i - 1];
            int end = binnary(help, s);
            System.out.println(end);
            if(end >= 0)
                count = Math.min(count, end - i + 1);
        }
        return count == Integer.MAX_VALUE? 0: count;

    }
    public int binnary(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        System.out.println(target + " " + nums[r]);
        if(target > nums[r]) return -1;
        while(l <= r){
            int mid = (l + r) >>> 1;
            if(nums[mid] > target){
                r = mid - 1;
            } else if(nums[mid] < target){
                l = mid + 1;
            } else{
                return mid;
            }
        }
        return l;
    }

    public int minSubArrayLen3(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;
        for(int end = 0; end < nums.length; end ++){
            sum += nums[end];
            if(sum >= target){
                count = Math.min(count, end - start + 1);
                System.out.println(start + " " + end);
                while(sum>=target && start <= end){
                    sum -= nums[start++];
                }
            }
        }
        return count;
    }

    public int minSubArrayLen4(int s, int[] nums) {
        int start = 0;

        int count = nums.length + 1;
        int sum = 0;
        for(int end = 0; end <  nums.length;){
            if(sum < s){
                sum += nums[end];
                end++;
            }
            while(sum >= s){  //若满足条件则左指针一直向左移动
                count = Math.min(count, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return count > nums.length? 0 : count;
    }



    public static void main(String[] args) {
        new L209_MinSubArrayLen().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
}
