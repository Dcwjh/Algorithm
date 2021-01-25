package NIUKE;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC41
 * @Date 1/15/2021 9:18 AM
 * @Version 1.0
 */


public class NC41 {
    public int maxLength (int[] arr) {
        // write code here
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        int temp = 0;
        while(right < arr.length){
            if(!set.contains(arr[right])){
                set.add(arr[right]);
                temp = Math.max(temp, right - left + 1);

            } else{
                while(set.contains(arr[right]) && left <= right){
                    set.remove(arr[left++]);
                }

            }
            right++;
            max = Math.max(max, temp);
        }
        return max;

    }

    public static void main(String[] args) {
        new NC41().maxLength(new int[]{2,2,3,4,3});
    }


}
