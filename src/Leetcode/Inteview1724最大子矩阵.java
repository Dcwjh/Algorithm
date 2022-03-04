package Leetcode;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Inteview1724最大子矩阵
 * @Date 2021/8/6 23:26
 * @Version 1.0
 */


public class Inteview1724最大子矩阵 {
    public static int[] getMaxMatrix(int[][] matrix) {
         int m = matrix.length; //行
         int n = matrix[0].length; //列
        //思考为什么需要多一行,求一行的时候；
         int[][] help = new int[m + 1][n];


        for(int col = 0; col < n; col++){
            for(int row = 1; row < m + 1; row++) {
                help[row][col] = help[row - 1][col] + matrix[row - 1][col];
            }
        }

        print(help);
        int max = Integer.MIN_VALUE;
        int[] res = new int[4];
        for(int sr = 0; sr < m; sr++){   //起始行
            for(int er = sr + 1; er < m + 1; er ++){  //终止行
                int sum = Integer.MIN_VALUE;
                int startcol = 0;
                for(int i = 0; i < n; i++){
                    if(sum > 0){
                        sum += help[er][i] - help[sr][i];
                    } else {
                        startcol = i;
                        sum = help[er][i] - help[sr][i];
                    }
                    if(sum > max){
                        max = sum;
                        res = new int[]{sr,startcol, er - 1, i}; //思考为什么er-1
                    }
                }
            }
        }
        return res;
    }


    public static void print(int [][] nums){
        for(int i = 0;i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
       int[][] nums = new int[][]{{9,-8,1,3,-2}, {-3,7,6,-2,4},{6,-4,-4,8,-7}};
        System.out.println();
        System.out.println();
        int[] temp = new int[]{1,1,1,1,2,2,2,2,2,2,3,3,3,3,4,4,4};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer num : temp){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        Integer[] key = map.keySet().toArray(new Integer[map.size()]);
        for(int i = 0; i < key.length; i++){
            System.out.print(key[i] + " ");
        }
//        int[] res = getMaxMatrix(nums);
//        for(int i= 0; i < res.length; i++){
//            System.out.print(res[i] + " ");
//        }
    }
}
