package xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln2
 * @Date 2021/9/9 19:19
 * @Version 1.0
 */

/*
有一个长度为n的序列A，序列中的第i个数为A[i] (1<=i<=n)，现在你可以将序列分成至多连续的k段。对于每一段，我们定义这一段的不平衡度为段内的最大值减去段内的最小值。显然，对于长度为1的段，其不平衡度为0。对于一种合法的分段方式（即每一段连续且不超过k段），我们定义这种分段方式的不平衡度为每一段的不平衡度的最大值。现在你需要找到不平衡度最小的分段方式，输出这种分段方式的不平衡度即可。
 */

/*
第一行两个空格隔开的整数n，k，分别表示序列的长度和最多可分成的段数。

第二行是n个用空格隔开的整数，第i个数表示A[i]的值。


一行一个整数，表示最小的不平衡度。
 */
public class ln2 {

    private static int fun(int[] nums, int k){
        if(k >= nums.length) return 0;
        int[] cha = new int[nums.length - 1];
        for(int i = 1; i < nums.length; i++){
            cha[i - 1] = Math.abs(nums[i] - nums[i - 1]);
        }
        Arrays.sort(cha);
        System.out.println(Arrays.toString(cha));
        return cha[nums.length - k - 1];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }

        System.out.println(fun(nums, k));

    }

}
