package qianxin;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln2
 * @Date 2021/9/23 15:51
 * @Version 1.0
 */


public class ln2 {
    public static  String[] Permutation (char[] seed, int size) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        Arrays.sort(seed);
        dfs(seed, new StringBuilder(), size, res);
        return res.toArray(new String[res.size()]);
    }

    private static void dfs(char[] seed, StringBuilder sb, int size, ArrayList<String> ans){
        if(sb.length() == size){

            ans.add(sb.toString());
        }
        for(int i = 0; i < seed.length; i++){
            if(seed[i] != ' '){
                char temp = seed[i];
                seed[i] = ' ';
                sb.append(temp);
                dfs(seed,  sb, size, ans);
                sb.deleteCharAt(sb.length() - 1);
                seed[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String[] ans = Permutation(new char[]{'0','1','2'},2);
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}
