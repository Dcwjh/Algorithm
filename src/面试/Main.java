package 面试;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Main
 * @Date 2021/7/31 19:37
 * @Version 1.0
 */


public class Main {


    public static ArrayList<Integer> fun(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        int temp = nums[0];
        boolean flag = true;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                if(flag) {
                    list.add(i + 1);
                    flag = false;
                }else
                    list.add(i + 2);
            }
        }
        return list;
    }






    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str = s.split(" ");
        int[] nums = new int[str.length];
        for(int i = 0; i< nums.length; i ++){
            nums[i] = Integer.parseInt(str[i]);
        }
        ArrayList<Integer> res = fun(nums);
        System.out.println(res.get(0));
        System.out.println(res.get(1));
    }
}
