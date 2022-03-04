import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Solution
 * @Date 2021/7/25 19:09
 * @Version 1.0
 */


public class Solution {
    public static boolean fun(int[][] nums){
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int max = nums[0][0];
        for(int i = 1; i < nums.length; i ++){
            if(max >= nums[i][1])
                return true;
            else
                max = nums[i][1];
        }
        return false;
    }


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] nums = new int[n][2];
//        for(int i = 0; i < n; i++){
//            nums[i][0] = sc.nextInt();
//            nums[i][1] = sc.nextInt();
//        }
//        System.out.println(fun(nums));

        System.out.println(36 % 72 == 0? "true" : "false");
    }
}
