/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName sxf
 * @Date 2021/8/31 16:40
 * @Version 1.0
 */


public class sxf {


    public static int[] nearestDiff (int[] nums) {
        // write code here
        int[] res = new int[nums.length];
        for(int i = 0; i <  nums.length; i++){
            int a = get_min(nums, i);
            int b = get_max(nums, i);
            if(a == -1)  a = 0;
            if(b == -1) b = 0;
            res[i] = b - a;
        }
        return res;

    }

    public static int get_min(int[] nums, int index){
        if(index == 0) return -1;

        for(int i = index - 1; i >= 0; i--){
            if(nums[index] > nums[i]){
                return nums[i];
            }
        }
        return -1;
    }

    public static int get_max(int[] nums, int index){
        if(index == nums.length - 1) return -1;
        for(int i = index + 1; i < nums.length; i++){
            if( nums[index] < nums[i]){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
