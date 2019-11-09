package StringAlgorithm;

import java.util.AbstractList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Test
 * @Date 2019/11/6 21:54
 * @Version 1.0
 */


public class Test extends AbstractList<Integer> {
    /*
    要实现一个不可修改的列表，程序员只需要扩展这个类并提供get(int)和size()方法的实现。
     */
    private int size;

    public Test(int size){
        this.size = Math.max(0,size);
    }


    @Override
    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Test(30));
    }
}
