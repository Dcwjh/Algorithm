package Test;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName zijiema
 * @Date 2021/9/1 9:51
 * @Version 1.0
 */


public class zijiema {
    public static  int fun(){
        int i = 0;
        try{
            return i++;
        }finally {
            return ++i;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
