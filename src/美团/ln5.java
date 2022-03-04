package 美团;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln5
 * @Date 2021/9/25 21:05
 * @Version 1.0
 */


public class ln5 {
    static boolean flag ;
    public static boolean fun(Integer[] nums, int k, int target){
        flag = false;
        dfs(nums, k, target, 0);
        return flag;
    }

    private static void dfs(Integer[] nums, int k, int target, int sum){
        if(flag) return;
        if(k == 0){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != null){
                    sum += nums[i];
                }
            }
            if(target == sum)
                flag = true;
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == null){
                continue;
            }
            Integer temp = nums[i];
            nums[i] = null;
            dfs(nums, k - 1, target, sum + temp * temp * temp);
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0;i < t; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            int target = in.nextInt();
            Integer[] nums = new Integer[n];
            for(int j =0; j < n; j++){
                nums[j] = in.nextInt();
            }
            if(fun(nums,k,target))
              System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
/*
2
2 1 10
1 2
4 3 37
1 1 2 3

 */