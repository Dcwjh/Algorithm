package 网易;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName 网易3
 * @Date 2021/8/21 15:07
 * @Version 1.0
 */


public class 网易3 {

    public static int fun(int[] nums){
        if(nums == null || nums.length ==0) return 0;
        if(nums.length == 1) return 1;
        Arrays.sort(nums);
        int[] help = new int[nums.length];
        help[0] = 1;
        for(int i = 1; i < help.length; i++){
            help[i] = help[i - 1];
            if(nums[i] > nums[i - 1]){
                help[i] += 1;
            }
        }
        int sum = 0;
        for(int num : help){
            sum += num;
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] s = str.split(" ");
        int[] nums = new int[s.length];
        for(int i = 0; i < s.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }

        System.out.println(fun(nums));

    }
}
