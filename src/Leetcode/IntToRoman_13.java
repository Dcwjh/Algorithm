package Leetcode;


/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName IntToRoman
 * @Date 12/7/2020 3:25 PM
 * @Version 1.0
 */


public class IntToRoman_13 {
    public String intToRoman(int num) {

        int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < 13){
            while(num>=nums[index]){
                sb.append(roman[index]);
                num-=nums[index];
            }
            index++;
        }
        return sb.toString();
    }
}
