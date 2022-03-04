import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Test816
 * @Date 2021/8/16 23:41
 * @Version 1.0
 */


public class Test816 {
    public int maxProfit(int[] nums) {
        if(nums.length < 2) return 0;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = 1; i < nums.length; i ++){
            int cur = nums[i];
            int pre = nums[i - 1];
            if(cur >= pre) sum += cur - pre;
            else{
                list.add(sum);
                sum = 0;
            }
        }
        Integer[] ans = list.toArray(new Integer[list.size()]);
        Arrays.sort(ans);
        int[] res = new int[]{1,2,3,4};
        Integer[] r = new Integer[res.length];


        return ans.length < 2? ans[0]: ans[0] + ans[1];

        }


}
