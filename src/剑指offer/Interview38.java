package 剑指offer;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Interview38
 * @Date 2021/3/8 9:45
 * @Version 1.0
 */


public class Interview38 {

        public String[] permutation(String s) {
            Set<String> list = new HashSet<>();
            char[] arr = s.toCharArray();
            boolean[] visited = new boolean[arr.length];
            dfs(arr, visited, "", list);
            return list.toArray(new String[0]);
        }

        //dfs,但是没有剪枝 63ms
        private void dfs(char[] arr, boolean[] visted, String res, Set<String> list){
            if(res.length() == arr.length){
                list.add(res);
                return;
            }
            for(int i = 0; i < arr.length; i++){
                if(visted[i]) continue;
                visted[i] = true;
                dfs(arr,visted,res+String.valueOf(arr[i]) , list);
                visted[i] = false;
            }
        }


        //剪枝 8ms
    public String[] permutation2(String s) {
        List<String> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        backTrack(list, arr, 0);
        return list.toArray(new String[list.size()]);

    }

    private void backTrack(List<String> list, char[] arr, int index){
            if(index == arr.length - 1){
                list.add(new String(arr));
                return;
            }

            HashSet<Character> set = new HashSet<>();
            for(int i = index; i < arr.length; i ++){
                if(set.contains(arr[i])) continue;
                //同层不用换,两个交换没有意义
                set.add(arr[i]);
                swap(arr, i, index);
                backTrack(list, arr, index + 1);
                swap(arr,i, index);
            }
    }
    private void swap(char[] arr, int left, int right){
            char a = arr[left];
            arr[left] = arr[right];
            arr[right] = a;
    }

    public static void main(String[] args) {
        new Interview38().permutation2("abc");
    }



}
