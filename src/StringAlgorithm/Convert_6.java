package StringAlgorithm;

/**
 * @Description Z字形变换
 * @Author Jianhai Wang
 * @ClassName Convert_6
 * @Date 2019/11/16 9:20
 * @Version 1.0
 */


public class Convert_6 {
    public static String convert(String s, int numRows) {
//        int n = (s.length())%(numRows*2 - 2);
//        int num = ((s.length())/(numRows*2 - 2))*(numRows - 1);
//        int numCols = 0;
//        if(n==0) {
//            numCols = num;
//        }
//        else if(n <= numRows){
//            numCols = num + 1;
//        }
//        else {
//            numCols = num + n - numRows + 1;
//        }
        if(s.length() <= numRows || numRows == 1)
            return s;
        char[][] str = new char[numRows][s.length()];
        int len = 0,row = 0,col = 0;
        while(s.length()>len) {
            while(row < numRows){
                if(s.length() > len)
                    str[row++][col] = s.charAt(len++);
                else
                    break;
            }
            col += 1;
            row -= 2;
            while (row > 0) {
                if (s.length() > len)
                    str[row--][col++] = s.charAt(len++);
                else
                    break;
            }
        }
        print(str);
        StringBuilder newstr = new StringBuilder();
        for(int i = 0; i < str.length; i++)
            for(int j = 0; j < str[0].length;j++)
                if(str[i][j]!=0)
                    newstr.append(str[i][j]);
//        return String.valueOf(newstr);
        return newstr.toString();
    }


    public static void print(char[][] str){
        for(int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[0].length; j++)
                System.out.print(str[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println(convert("ABCDE",4));
        System.out.println(convert("LEETCODEISHIRING",4));
        System.out.println(convert("LEETCODEISHIRING",3));
    }
}
