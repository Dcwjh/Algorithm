package 同花顺;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName B
 * @Date 2021/9/13 16:25
 * @Version 1.0
 */


public class B {

    static class Student{
        int num;
        public void setNum(int num){
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Student stu = new Student();
        List<Student> list = new ArrayList<>();
        for(int i= 0; i < 10; i++){
            stu.setNum(i);
            list.add(stu);
        }
    }



}
