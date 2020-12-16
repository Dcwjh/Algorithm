package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L108_SortedArrayToBST
 * @Date 12/15/2020 4:58 PM
 * @Version 1.0
 */


public class L108_SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length ==0 )return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right){
        if( left > right){
            return null;
        }
        int mid = (left + right) >>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

}
