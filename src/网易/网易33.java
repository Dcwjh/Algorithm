package 网易;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName 网易33
 * @Date 2021/8/21 15:27
 * @Version 1.0
 */


public class 网易33 {

    public static int fun(int[] nums){
        if(nums == null) return 0;
        if(nums.length == 1) return 1;
        if(nums.length == 2){
            if(nums[0] == nums[1])
                return 2;
            else return 3;
        }
        int[] help = new int[nums.length];
        Arrays.fill(help, 1);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                help[i] = help[i - 1] + 1;
            }
        }
        if(nums[0] > nums[nums.length - 1]){
            help[0] = help[nums.length - 1] + 1;
            for(int i = 1; i < nums.length; i++){
                if(nums[i] > nums[i - 1]){
                    help[i] = help[i - 1] + 1;
                } else if(nums[i] == nums[i - 1]){
                    help[i] = help[i - 1];
                }
            }
        }
        for(int i = nums.length - 2; i>= 0; i--){
            if(nums[i] > nums[i + 1]){
                help[i] = help[i + 1] + 1;
            }
        }

        if(nums[nums.length - 1] > nums[0]){
            help[nums.length - 1] = help[0] + 1;
            for(int i = nums.length - 2; i>= 0; i--){
                if(nums[i] > nums[i + 1]){
                    help[i] = help[i + 1] + 1;
                } else if(nums[i] == nums[i + 1]){
                    help[i] = help[i + 1];
                }
            }
        }
        for(int num : help){
            System.out.print(num + " ");
        }
        System.out.println();
        int sum = 0;
        for(int num: help){
            sum+=num;
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
