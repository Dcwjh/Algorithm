import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName RedHat3
 * @Date 2021/9/4 10:27
 * @Version 1.0
 */


public class RedHat3 {
    static int[][] tree;
    static int k;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        k = in.nextInt();
        int[][] nums = new int[n - 1][3];
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = in.nextInt();
                if (j != 2) {
                    max = Math.max(max, nums[i][j]);
                }
            }
        }

        int m = max + 1;
        tree = new int[m ][m];
        for (int i = 0; i < m; i++)
            Arrays.fill(tree[i], Integer.MIN_VALUE);

        for (int i = 0; i < n - 1; i++) {
            tree[nums[i][0]][nums[i][1]] = nums[i][2];
            tree[nums[i][1]][nums[i][0]] = nums[i][2];
        }

        System.out.println(fun());
    }


    private static int fun() {
        int n = tree.length;
        int res = 0;

        for(int start = 0; start < n; start ++){
            for(int end = 0; end < n; end++){
                for(int mid = 0; mid < end; mid ++){
                    if(mid == end || start == mid ) continue;
                    int temp = 0;
                    if(tree[start][mid] > 0 && tree[mid][end] > 0){
                        temp = tree[start][mid] + tree[mid][end];
                    }
                    if(temp != 0 && temp <= k){
                        if(tree[start][end] > 0){
                            tree[start][end] = Math.min(tree[start][end], temp);
                            tree[end][start] = Math.min(tree[start][end], temp);
                        }else{
                            tree[start][end] = temp;
                            tree[end][start] = temp;
                        }

                    }
                }
            }
        }
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                System.out.print(tree[i][j] + " ");
            }
            System.out.println();
        }

        //对称求一半
        for(int i = 0; i < n - 1 ; i++){
            for(int j = i + 1; j < n; j++){
                if(tree[i][j] > 0 && tree[i][j] <= k)
                    res ++;
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


8
 */
