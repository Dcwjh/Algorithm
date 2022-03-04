package 美团;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln4
 * @Date 2021/9/11 17:12
 * @Version 1.0
 */


public class ln4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = Integer.parseInt(in.nextLine());
        //求出所有周期
        int[] nums = new int[s.length()];
        int index = 0;


        for(int p = 1; p < s.length(); p++){
            for(int i = 0; i < s.length() - p; i++){
                if(s.charAt(i) != s.charAt(i + p)){
                    break;
                } else if(i == s.length() - p - 1){
                    nums[index ++] = p;
                }
            }
        }
        nums[index] = s.length();


//       for(int i = 0; i < nums.length; i++){
//           System.out.print(nums[i] + " ");
//       }

        for(int i = 0; i < n; i++){
            String[] temp = in.nextLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int k = Integer.parseInt(temp[1]);
            System.out.println(fun(s, u, k,nums));
        }

    }

    private static int fun(String s, int u, int k, int[] nums){
        if(u < nums[0] && k == 1) return u;
        int temp = 0;
        for(int i = 0; i < k; i++){
            if(k > nums.length || nums[k] == 0){
                return -1;
            } else{
                if(nums[i] <=  u){
                    temp = nums[k];
                }
            }
        }
        return temp;
    }
}
