package NIUKE;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC121
 * @Date 2021/1/22 13:41
 * @Version 1.0
 */


public class NC121 {
    ArrayList<String> ans = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0) return ans;

        dfs(str.toCharArray(), 0, new ArrayList<Character>());


        return ans;
    }


    private void dfs(char[] s, int index, ArrayList<Character> res){
        if(index == s.length - 1) {
            if(!ans.contains(new String(s))) {
                ans.add(new String(s));
            }
            return;
        }
        for(int i = index; i< s.length; i++){
            res.add(s[i]);
            swap( s,i,index);
            dfs(s,index + 1, res);
            swap(s, i, index);
        }

    }

    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
