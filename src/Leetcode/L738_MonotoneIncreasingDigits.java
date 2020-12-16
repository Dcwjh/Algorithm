package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L738_MonotoneIncreasingDigits
 * @Date 12/15/2020 8:51 AM
 * @Version 1.0
 */


public class L738_MonotoneIncreasingDigits {
    //算法思想：逆序找到最后一个逆序的相邻数字，把前面的数字减一，把它之后的所有数字设置为9
    public static int monotoneIncreasingDigits(int N) {
        //第一步将N转化为字符串
        String s = String.valueOf(N);
        char[] str = s.toCharArray();
        int start = str.length; //处理情况要在最后面，万一不需要处理呢
        for(int i = str.length - 1; i > 0; i--){
            if(str[i] >= str[i - 1]){ //特殊情况==也是不需要处理的
                continue;
            }
            str[i - 1]--;
            start = i;
        }
        while(start < str.length){
            str[start++] = '9';
        }
        return Integer.parseInt(String.valueOf(str));

        //字符串转化为字符数组
        //处理字符数组
        //
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(10));
    }
}
