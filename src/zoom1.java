import java.util.ArrayList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName zoom1
 * @Date 2021/8/28 17:25
 * @Version 1.0
 */


public class zoom1 {

    public int find132Pattern (int[] nums) {
        // write code here
        if(nums.length < 3) return 0;
        int count = 0;
        int a = nums[0];
        int b = nums[1];
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(judge(nums[i],nums[j],nums[k])){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean judge(int a, int b, int c){
        if(a < c && c < b){
            return true;
        }
        return false;
    }



    public static int[] slideWindow (int[] nums, int windowSize, int step) {
        // write code here
        if(nums.length < step) {
            int max = maxfun(nums, 0, nums.length - 1);
            return new int[]{max};
        }
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = windowSize - 1;
        while(j < nums.length - step){
            int temp = maxfun(nums, i, j);
            res.add(temp);
            i+= step;
            j+= step;
        }
        j = j - step + 1;
        i = i - step + 1;
        while(j < nums.length){
            int temp = maxfun(nums, i, j);
            res.add(temp);
            i+= 1;
            j+= 1;
        }

        int[] list = new int[res.size()];
        for(int k = 0; k < list.length; k++){
            list[k] = res.get(k);
        }
        return list;
    }

    private static int maxfun(int[] nums, int start, int end){
        int max = nums[start];
        for(int i = start + 1; i <= end; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
