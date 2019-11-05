package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Given a sorted integer array where the range of the range of element are in the inclusive range
 * {lower, upper}, return its missing ranges.
 *
 * For example,
 * given {0,1,3,50,75}, lower = 0 and upper = 99
 * return ("2","4->49","51->74",76->99"}
 *
 * @Author Jianhai Wang
 * @ClassName MissingRanges
 * @Date 2019/11/5 15:30
 * @Version 1.0
*/



public class MissingRanges {

    private static List<String> findMissingRanges(int[] nums, int lower, int upper){
        //Step 1: Define return value
        List<String> rst = new ArrayList<>();

        //Step 2: handle corner cases
        if(nums == null || nums.length == 0)
        {
            rst.add(lower + "->" + upper);
            return rst;
        }

        //Step 3: Fill in business logic
        //first， add the range after lower
        addToList(rst, lower, nums[0] - 1);
        //second, add the ranges between lower and upper
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            int cur = nums[i];
            if(pre+1 != cur){
                addToList(rst, pre + 1,cur - 1);
            }
            pre = cur;
        }
        //third, add the range before upper
        addToList(rst, nums[nums.length - 1] + 1, upper);
        return rst;
    }

    private static void addToList(List<String> rts, int start, int end){
        if(start == end){
            rts.add(String.valueOf(start));
        }else if(start < end){
            rts.add(start + "->" + end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        List<String> rts = findMissingRanges(nums, lower, upper);
        System.out.println(rts.toString());
    }
}
