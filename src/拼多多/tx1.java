package 拼多多;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName tx1
 * @Date 2021/8/22 21:15
 * @Version 1.0
 */


public class tx1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int m = in.nextInt();
            int load = in.nextInt();
            int[] nums = new int[m];
            for(int j = 0; j < m; j++){
                nums[j] = in.nextInt();
            }
            System.out.println(fun(nums, load));
        }
    }

    private static int fun(int[] nums, int load){
        int oddnums = 0;
        for(int num : nums){
            if((num & 1) == 0) oddnums ++;
        }
        //偶数
        int[] odd = new int[oddnums];
        int[] even = new int[nums.length - oddnums];
        int i = 0;
        int j = 0;
        int k = 0;
        while(k < nums.length){
            if((nums[k] &1)  == 0){
                odd[i ++] = nums[k++];
            }else{
                even[j++] = nums[k++];
            }
        }
        
        int res = 0;
        //偶数求解
        int l = 0;
        int r = odd.length - 1;
        while(l <= r){
            if(l == r && load>=odd[l]) {
                res ++;
                l ++;
                r--;
            }
            else{
                if(odd[l] + odd[r] <= load){
                    res++;
                    l++;
                    r--;
                } else{
                    res++;
                    r--;
                }
            }
        }



        l = 0;
        r = even.length - 1;
        while(l <= r){
            if(l == r && load>=even[l]) {
                res ++;
                l ++;
                r--;
            }
            else{
                if(even[l] + even[r] <= load){
                    res++;
                    l++;
                    r--;
                } else{
                    res++;
                    r--;
                }
            }
        }
        return res;
    }
}
