package 拼多多;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName rln1
 * @Date 2021/9/22 15:08
 * @Version 1.0
 */


public class rln1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;  i < n; i++){
            nums[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] help = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            help[i] = sum;
        }
        for(int i = 0; i < m; i ++){
            int find = in.nextInt();
            int l = 0;
            int r = nums.length - 1;
            int mid = 0;
            while(l < r){
                mid = (l + r)/2;
                if(help[mid] > find){
                    r = mid ;
                } else if(help[mid] < find){
                    l = mid + 1;
                } else {
                    break;
                }
            }
            while(true){
                if(find <= help[mid]){
                    System.out.println(mid + 1);
                    break;
                }else{
                    mid ++;
                }
            }

        }
    }
}
/*
5
1 3 5 2 4
3
4 2 7
 */