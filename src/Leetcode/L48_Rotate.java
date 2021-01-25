package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L48
 * @Date 1/9/2021 5:41 PM
 * @Version 1.0
 */


public class L48_Rotate {
    //方法一：使用辅助数组，让第一行变成倒数第一列，第二行变成倒数第二列，以此类推
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[j][n - i - 1]   = matrix[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }

    }

    //方法二： 找规律，按块来置换，只要是找坐标
    public void rotate1(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < (n + 1)/2;i++){
            for(int j = 0; j < n/2; j++){
                int t1 = matrix[j][n - i - 1];
                int t2 = matrix[n - i - 1][n - j - 1];
                int t3 = matrix[n - j - 1][i];
                matrix[j][n - i - 1] = matrix[i][j];
                matrix[n - i - 1][n - j - 1] = t1;
                matrix[n - j - 1][i] = t2;
                matrix[i][j] = t3;
            }
        }
    }

    //方法三：先水平置换，然后在对角线置换
    public void rotate3(int[][] matrix){
        int n = matrix.length;
        //水平置换
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        //对角线置换
        for(int i = 0; i < n; i ++){
            for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println("------------------------------");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        new L48_Rotate().rotate3(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }



}
