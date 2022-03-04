import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName RedHat
 * @Date 2021/9/4 10:11
 * @Version 1.0
 */


public class RedHat {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                nums[i][j] = in.nextInt();
            }
        }

        System.out.println(fun(nums));
    }


    private static int fun(int[][] nums){
        int n = nums.length;
        int[][] help = new int[n + 1][n];
        for(int row = 1; row < n + 1; row++){
            for(int col = 0; col < n; col++)
            help[row][col] = help[row - 1][col] + nums[row - 1][col];
        }
//        for(int row = 0; row < n + 1; row++){
//            for(int col = 0; col < n; col++){
//                System.out.print(help[row][col] + " ");
//            }
//            System.out.println();
//        }
        int res = Integer.MIN_VALUE;
        for(int start = 0; start < n; start ++){
            for(int end = start + 1; end < n + 1; end ++){
                int sum = help[end][0] - help[start][0];
                for(int i = 1; i < n; i++){
                    if(sum > 0){
                        sum += help[end][i] - help[start][i];
                    } else{
                        sum = help[end][i] - help[start][i];
                    }
                    res = Math.max(sum, res);
                }
            }
        }

        return res;
    }
}
/*

5 4
1 2 3
1 3 1
1 4 2
3 5 1

 */