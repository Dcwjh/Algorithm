package NIUKE;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC61
 * @Date 1/13/2021 3:56 PM
 * @Version 1.0
 */


public class NC61 {
    public int[] twoSum (int[] numbers, int target) {
        // write code here

        //将nums[i] - target,作为键值， i作为value
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(hashMap.containsKey(numbers[i])){
                return new int[]{hashMap.get(numbers[i]), i + 1};
            }
            hashMap.put(target - numbers[i], i+ 1);
        }
        return null;
    }
}
