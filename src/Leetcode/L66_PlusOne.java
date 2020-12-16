package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L66_PlusOne
 * @Date 12/15/2020 1:46 PM
 * @Version 1.0
 */


public class L66_PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            digits[i]++;
            digits[i] = digits[i]%10;
            if(digits[i]!=0) return digits;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return  ans;
    }
}
