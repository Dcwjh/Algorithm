package 剑指offer;

/**
 * @Description 左旋转字符串
 * @Address https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @Author Jianhai Wang
 * @ClassName Interview58_2
 * @Date 2020/6/30 11:10
 * @Version 1.0
 */


public class Interview58_2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverse(sb,0, n - 1);
        reverse(sb,n, s.length() - 1);
        reverse(sb,0, s.length() - 1);
        return sb.toString();

    }

    //翻转字符串
    private void reverse(StringBuilder sb, int left, int right) {
        while(left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }
}
