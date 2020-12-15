package Leetcode;

/**
 * @Description 跳跃游戏：Leetcode 55题：https://leetcode-cn.com/problems/jump-game/
 * @Author Jianhai Wang
 * @ClassName CanJump_55
 * @Date 2019/11/21 10:50
 * @Version 1.0
 */


public class L55_CanJump {
    /**
     * @param nums  数组能跳的个数
     *
     * @Description 最简单解法
     * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
     * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
     * 如果可以一直跳到最后，就成功了。
     */
    public static boolean canJump1(int[] nums) {
        int k = 0; //能跳的最远距离
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;  //跳不到第i个位置时，结束
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }


    /**
     * @Description 动态规划:自底向上
     * @param nums
     * @return
     * 思想：能跳到的地方都是true.判断最后一个是否为true
     */
    public static boolean canJump2(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j <= nums[i]; j++){
                if(dp[nums.length - 1])
                    return true;
                if(dp[i] && i + j < nums.length)
                    dp[i + j] = true;
            }
        }
        return false;
    }

    /**
     * @Description 递归（回溯）
     * @param nums
     * @return
     */
    public static boolean canJump3(int[] nums) {
        return canJumpFromPosition(0,nums);
    }

    public static boolean canJumpFromPosition(int position, int[] nums){
        //结束递归的条件
        if(position == nums.length - 1)
            return true;
        //递归处理

        //下一跳能跳的最远距离
        int furthestJump = Math.min(position + nums[position], nums.length-1);
        //下一跳
        for(int nextJumpPosition = position + 1; nextJumpPosition <= furthestJump; nextJumpPosition++){
            if(canJumpFromPosition(nextJumpPosition,nums))
                return true;
        }
        return false;
    }

    /**
     * @Description 自顶向下：记忆化。从结果出发看是否能回到出发点
     * @param nums
     * @return
     */
    public static boolean canJump4(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        dp[nums.length - 1] = true;
//        System.out.println(Arrays.toString(dp));
        for(int j = nums.length - 1; j>=0; j--){
            //把能到达最终位置的dp置为true
            if(dp[j]){
                int max = Math.max(0,j-nums[j]);
                //第一个起始位置
                for(int i = max; i <= nums[i]; i++)
                    if(nums[i] + i >= j)
                        dp[i] = true;
//                System.out.println(Arrays.toString(dp));
            }

        }
        return dp[0];

    }

    /**
     * @Description 贪心算法：
     * 从右向左迭代，对于每个节点我们检查是否存在一步跳跃可以到达 true 的位置（currPosition + nums[currPosition] >= leftmostGoodIndex）。
     * 如果可以到达，当前位置也标记为 true ，同时，这个位置将成为新的最左边的 true 位置，
     * 一直重复到数组的开头，如果第一个坐标标记为true 意味着可以从第一个位置跳到最后的位置。
     * @param nums
     * @return
     */


    public static boolean canJump5(int[] nums) {
        int leftPos = nums.length - 1;
        for(int i = nums.length - 1; i >= 0;i--){
            if(i + nums[i] >= leftPos) {
                leftPos = i;
            }
        }
        return leftPos == 0;
    }



    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums1 = {3,2,1,0,4};
        System.out.println(canJump5(nums));
        System.out.println(canJump5(nums1));
    }
}






