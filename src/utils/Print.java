package utils;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Print
 * @Date 2019/11/5 22:42
 * @Version 1.0
 */


public class Print {
    public static void printArray(int[] arr) {
        if (arr == null)
            return;
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void printArray(int[][] arr) {
        if(arr == null)
            return;
        System.out.println("数组如下：");
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
