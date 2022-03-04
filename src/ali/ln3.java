package ali;

import java.nio.ByteOrder;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln3
 * @Date 2021/9/18 10:15
 * @Version 1.0
 */


public class ln3 {

    public static void main(String[] args) {

        if(ByteOrder.nativeOrder()==ByteOrder.BIG_ENDIAN)

            System.out.println("big endian");
        else System.out.println("little endian");

    }
}
