package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L136_SingleNumber
 * @Date 12/16/2020 3:11 PM
 * @Version 1.0
 */


public class L136_SingleNumber {

    /**
     * 位运算
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int num: nums){
            ans ^= num;
        }
        return ans;
    }

    /**
     * Hash
     */
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i : nums){
            if(map.get(i) == null)
                map.put(i,1);
            else if(map.get(i) == 1)
                map.put(i,2);

        }
        for(int i:nums)
            if(map.get(i) == 1)
                return i;
        return -1;
    }

}
