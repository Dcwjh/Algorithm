package 拼多多;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName In1
 * @Date 2021/8/22 20:32
 * @Version 1.0
 */


public class In1 {

    private static int fun(int[][] nums){
        Arrays.sort(nums, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1] - o2[1];
                }
                return o2[0]- o1[0];
            }
        });
        int count = 1;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i][1] >= count){
                System.out.println("jiangshang" + nums[i][0]);
                res += nums[i][0];
                count++;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int num = in.nextInt();
            int[][] nums = new int[num][2];
            for(int j = 0;j < num; j++){
                nums[j][0] = in.nextInt();
                nums[j][1] = in.nextInt();
            }
            System.out.println(fun(nums));
        }

    }
}
