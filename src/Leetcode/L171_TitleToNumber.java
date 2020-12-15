package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName TitleToNumber_171
 * @Date 12/9/2020 4:34 PM
 * @Version 1.0
 */


public class L171_TitleToNumber {
    public static int titleToNumber(String s) {
        char[] str = s.toCharArray();
        int ans = 0;
        for(int i = str.length - 1; i >= 0 ; i--){
            ans+= ans * 26 + (str[i] - 'A' + 1) * Math.pow(26,str.length - 1 - i);
        }
        return ans;
    }

    public static int titleToNumber2(String s) {
        char[] str = s.toCharArray();
        int ans = 0;
        for(int i = 0; i < str.length ; i++){
            ans = ans * 26 + str[i] - 'A' + 1;
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(titleToNumber2("ZY"));
    }
}
