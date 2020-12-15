package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName LemonadeChange_860
 * @Date 12/10/2020 9:13 AM
 * @Version 1.0
 */


public class L860_LemonadeChange {
    public static  boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for(int i = 0; i < bills.length;i ++){
            if(bills[i] == 5){
                five++;
            } else if(bills[i] == 10){
                ten ++;
                five --;
                if(five < 0)
                    return false;
            } else if(bills[i] == 20){
                twenty++;
                if(ten > 0 && five > 0){
                    ten --;
                    five --;
                }else {
                    five = five - 3;
                }
                if( five < 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5}));
    }
}
