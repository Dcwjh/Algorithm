package WEBANK;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName wn3
 * @Date 2021/8/27 20:40
 * @Version 1.0
 */


public class wn3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i]  = in.nextInt();
        }

        Arrays.sort(nums);
        int date = 1; //第i天的食量就是i
        int index = 0;
        while(index < n){
            if(date <= nums[index]){
                date ++;
            }
            index ++;
        }
        System.out.println(date);
    }
}
