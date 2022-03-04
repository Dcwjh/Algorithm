package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L354俄罗斯信封套娃问题
 * @Date 2021/8/15 11:28
 * @Version 1.0
 */


public class L354俄罗斯信封套娃问题 {
    public static  int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])  return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        //第一个升序，第二个逆序
        int[] dp  = new int[envelopes.length];
        Arrays.fill(dp, 1);
        System.out.println(envelopes.length);

        for(int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }


        }
        int max  = 0;
        for(int i = 0; i < dp.length; i++){
            max = Math.max(max, dp[i]);
        }


        for(int i = 0; i  < envelopes.length; i++){
            System.out.print(envelopes[i][0] + " ");
        }
        System.out.println();
        for(int i = 0; i  < envelopes.length; i++){
            System.out.print(envelopes[i][1] + " ");
        }


        return max;
    }



    public static int maxEnvelopes2(int[][] nums) {
        Arrays.sort(nums, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0])
                    return o1[0] - o2[0];
                else
                    return o2[1] - o1[1];
            }
        });

        List<Integer> list = new ArrayList<>();
        list.add(nums[0][1]);
        for(int i = 0; i < nums.length; i++){
            if(nums[i][1] > list.get(list.size() - 1)){
                list.add(nums[i][1]);
            } else{
                int temp = nums[i][1];
                int index = binarySearch(list, temp);
                list.set(index, temp);
            }
        }
        return list.size();
    }

    public static  int binarySearch(List<Integer> list, int num){
        int l = 0;
        int r = list.size() - 1;
        while(l < r){
            int mid = l + (r - l) /2;
            if(list.get(mid) < num){
                l = mid + 1;
            } else{
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
            {1,2},{1,4},{1,5},{2,3}
        };
        System.out.println(maxEnvelopes2(nums));
    }

}
