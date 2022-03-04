import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Main2
 * @Date 2021/7/31 20:03
 * @Version 1.0
 */


public class Main2 {
    static HashMap<Integer, Integer> hash = new HashMap<>();
    static int res = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    //上一位是是偶
    public static int fun(int k, int x){
        for(Integer n : list){
            if(check(n))
                res ++;
        }
        return res;
    }

    static boolean check(int num){
        return true;
    }

    //生成所有数字
    public static void dfs(String[] s, int m, int k, String num) {
        if(m == k) list.add(Integer.parseInt(num));
        for(int i = 0; i < s.length; i++) {
            if (!s[i].equals("#")) {
                String temp = s[i];
                s[i] = "#";
                dfs(s, m, k + 1, num + temp);
                s[i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] str1 = s1.split(" ");
        int n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        int k = Integer.parseInt(str1[2]);
        int x = Integer.parseInt(str1[3]);
        String str = sc.nextLine();
        String[] s = str.split(" ");

    }
}
