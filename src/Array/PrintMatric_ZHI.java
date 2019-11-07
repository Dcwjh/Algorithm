package Array;

/**
 * @Description 找好边界问题
 * @Author Jianhai Wang
 * @ClassName PrintMatric_ZHI
 * @Date 2019/11/7 9:28
 * @Version 1.0
 */


public class PrintMatric_ZHI {
    public static void printMatrix(int[][] nums){
        int Arow = 0;
        int Acol = 0;
        int Brow = 0;
        int Bcol = 0;
        int endRow = nums.length - 1;
        int endCol = nums[0].length - 1;
        boolean flag = false;
        while(Arow <= endRow ){
            print(nums, Arow, Acol, Brow, Bcol, flag);
            Arow = Acol == endCol ? Arow + 1 : Arow;
            Acol = Acol == endCol  ? Acol : Acol + 1;
            Bcol = Brow == endRow  ? Bcol + 1 : Bcol;
            Brow = Brow == endRow  ? Brow : Brow + 1;

            flag = !flag;
        }
    }

    public static void print(int[][] nums, int Arow, int Acol, int Brow, int Bcol, boolean flag){
        if(flag) {
            while (Arow <= Brow) {
                System.out.print(nums[Arow++][Acol--] + " ");
            }
        }
        else{
            while (Brow >= Arow )
                System.out.print(nums[Brow--][Bcol++] + " ");
        }

    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        printMatrix(a);
    }

}
