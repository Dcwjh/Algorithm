package Blili;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln1
 * @Date 2021/9/13 19:32
 * @Version 1.0
 */


public class ln1 {

    public static int dfs(int[][] nums, int x, int y){
        if(x < 0 || y < 0 || x >= nums.length || y >= nums.length){
            return 0;
        }
       if(nums[x][y] == 1){
           nums[x][y] = 0;
           return 1 + dfs(nums, x, y + 1) + dfs(nums, x, y - 1) + dfs(nums, x + 1, y) + dfs(nums, x - 1, y);
       }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        while(in.hasNextLine()) {
            String line = in.nextLine();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '0' || line.charAt(i) == '1') {
                    list.add(Integer.parseInt(String.valueOf(line.charAt(i))));
                }
            }
            lists.add(list);
        }
        int n = lists.size();
        int m = lists.get(0).size();
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = lists.get(i);
            for(int j = 0; j < m; j++){
                nums[i][j] = temp.get(j);
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }


        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++){
                if(nums[i][j] == 1)
                    res = Math.max(res, dfs(nums, i, j));
            }
        }
        System.out.println(res);
    }
}
