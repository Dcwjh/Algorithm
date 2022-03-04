package 面试;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName StrInt
 * @Date 2021/7/31 15:44
 * @Version 1.0
 */


public class StrInt {

    public static long fun(String nums) {
        int len = nums.length();
        long sum = 0;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if(nums.charAt(i) == '-'){
                    flag = true;
                    continue;
                } else if(nums.charAt(i) == '0'){
                    return 0;
                }
            }
            if (Character.isDigit(nums.charAt(i))) {
                int value = nums.charAt(i) - '0';
                if (flag) {
                    sum -= value * Math.pow(10, len - i - 1);
                } else {
                    sum += value * Math.pow(10, len - i - 1);
                }
            } else {
                return 0;
            }
        }
        if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) return 0;
        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(fun("12311113333333333333333333331111111111111111111123324444444444444444444444444444444444444444444444444444444444444444444444444"));

        String s = "0123456789";
        System.out.println(s.charAt(2));
    }

}
