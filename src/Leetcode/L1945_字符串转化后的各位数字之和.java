package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1945_字符串转化后的各位数字之和
 * @Date 2021/7/29 23:30
 * @Version 1.0
 */


public class L1945_字符串转化后的各位数字之和 {
    public static int getLucky(String s, int k) {
        //主要考察字符串与整数的转换
        StringBuilder sb = new  StringBuilder();
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++){
            sb.append(str[i] - 'a' + 1);
        }
        int sum = 0;
        s = sb.toString();
        while(k > 0){
            sum = 0;
            for(int i = 0; i < s.length(); i++){
                sum += s.charAt(i) - '0';
            }
            k--;
            s = String.valueOf(sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getLucky("leetcode", 2));
    }
}
