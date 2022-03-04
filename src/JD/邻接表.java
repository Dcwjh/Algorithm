package JD;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName 邻接表
 * @Date 2021/9/11 21:10
 * @Version 1.0
 */


public class 邻接表 {
    static class Node{
        int key;
        Node relation = new Node(0); //子节点的头节点
        public Node(int val){
            this.key = val;
        }
    }

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        int e = 200;
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(e == d);

    }
}
