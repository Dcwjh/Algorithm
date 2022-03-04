package tushen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln3
 * @Date 2021/9/18 20:35
 * @Version 1.0
 */


public class ln3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] strings = string.split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) { //n个单词
            int[] count = new int[26];
            String temp = in.nextLine();
            char[] t = temp.toLowerCase().toCharArray();
            for (char x : t) {
                count[x - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sb.append(String.valueOf(j + 'a'));
                sb.append(count[j]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }


        //k个相似度

        //相似个数
        int res = 0;
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int temp = entry.getValue();
            if (temp >= 2) {

                list.add(temp);
                sum+= temp;
            }
        }

        if(list.size() < k) System.out.println(0);
        else if(list.size() == k) {
            res = (int)Math.pow(2, n - k * 2);
            System.out.println(res %(int)(Math.pow(10, 9) + 7));
        }

    }
}
/*
3 1
ovo
ono
voo
 */