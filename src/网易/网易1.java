package 网易;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName 网易1
 * @Date 2021/8/21 15:21
 * @Version 1.0
 */


public class 网易1 {

    private static int fun(int[]  nums, int target){

        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] <= target){
                    res ++;
                }else{
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int target = in.nextInt();
        String[] s = str.split(" ");
        int[] nums = new int[s.length];
        for(int i = 0; i < s.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }

        System.out.println(fun(nums,target));

    }
}
