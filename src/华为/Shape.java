package 华为;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Shape
 * @Date 2021/9/16 15:15
 * @Version 1.0
 */


interface Shape {
    void draw(String obj);
    void draw(Integer obj);
}

class Circle implements Shape {
    public void draw(String s) {
        System.out.println("String");
    }

    @Override
    public void draw(Integer obj) {
        System.out.println("Integer");
    }
}

class Square implements Shape {
    @Override
    public void draw(String obj) {
        System.out.println("String");
    }

    public void draw(Integer o) {
        System.out.println("Integer");
    }

}
class Main{
    public static void main(String[] args) {
        Shape a = new Circle();

    }
}