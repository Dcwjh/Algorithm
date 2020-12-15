package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Jianhai Wang
 * @ClassName FourSumCount_454
 * @Date 11/27/2020 4:43 PM
 * @Version 1.0
 */


public class L454_FourSumCount {
    //题目要个数，可以考虑键值对，正反为0
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int a: A)
            for(int b : B)
                map.put(a + b, map.getOrDefault(a+b, 0) + 1);
        int count = 0;
        for(int c: C) {
            for (int d: D) {
                if (map.containsKey(-c -d)){
                    count += map.get(-c-d);
                }
            }
        }
        return count;
    }
}
