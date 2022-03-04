package 面试;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName baidu2
 * @Date 2021/9/7 20:12
 * @Version 1.0
 */


public class baidu3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] inputs = input.split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        String string = in.nextLine();
        char[] ch = string.toCharArray();
        int color = 0;
        int i = 0;
        int j = 0;
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j < ch.length){
            while(color <= k && j < ch.length) {
                if (!map.containsKey(ch[j]) || map.get(ch[j]) == 0) {
                    map.put(ch[j], 1);
                    color ++;
                    j++;
                } else {
                    map.put(ch[j], map.get(ch[j]) + 1);
                    j++;
                }

            }

            //子序列
            int sum = 0;
            if(color == k) {

                for (int p = i; p <= j && p < ch.length; p++) {
                    sum += map.get(ch[p]);
                }
                res += sum - k;
            }

            while(i < ch.length && i <= j && color == k){
                map.put(ch[i], map.get(ch[i]) - 1);
                if(map.get(ch[i]) == 0){
                    color --;
                }
                i++;
            }
        }
        System.out.println(res);
    }
}
/*
6 5
eecbad
 */