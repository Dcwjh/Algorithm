package 剑指offer;

/**
 * @Description 连续子数组的最大和
 * @Address https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&&tqId=11183&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @Author Jianhai Wang
 * @ClassName Interview42
 * @Date 2020/6/24 22:34
 * @Version 1.0
 */


public class Interview42 {
    //累加和，看该数对原来的和是否有贡献
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
            max = Math.max(sum, max);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;

    }

    //动态规划
    public int FindGreatestSumOfSubArray2(int[] array) {
        if(array == null || array.length == 0)
            return 0;
        int[] hp = new int[array.length];
        hp[0] = array[0];
        for(int i = 1; i < array.length; i++){
            if(hp[i - 1] <= 0)
                hp[i] = array[i];
            else
                hp[i] = array[i] + hp[i - 1];
        }
        //找出hp数组中的最大值
        int max = hp[0];
        for(int i = 0; i < hp.length; i++){
            max = Math.max(max,hp[i]);
        }
        return max;
    }


}
