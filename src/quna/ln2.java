package quna;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln2
 * @Date 2021/9/14 18:04
 * @Version 1.0
 */


public class ln2 {
    public static int solution(int[] arr) {
        //负数放在一个数组，正数放在一个数组



        Integer[] nums = new Integer[arr.length];
        for(int i = 0;i < arr.length ; i++){
            nums[i] = arr[i];
        }

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int k = 1;
        int max = 0;
        //统计负数的个数
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0) cnt ++;
        }
        for(int i = 0; i <= cnt; i++) {
            int sum = 0;
            k = 1;
            for (int j = i; j < nums.length; j++) {
                sum += k * nums[j];
                k++;
            }
            max = Math.max(sum, max);
        }

        return max;
    }


        public static void main(String[] args){
            int[] nums = new int[]{1,4};
            System.out.println(solution(nums));

        }

}
