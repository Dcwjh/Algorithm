package 面试;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName 美团4
 * @Date 2021/8/8 11:18
 * @Version 1.0
 */

class Node{
    int i;
    int j;
    Node(int i, int j){
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return (i == node.i &&
            j == node.j) || (i == node.j && j == node.i);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i + j, i + j);
    }
}

public class 美团4 {
    public static int fun(int[] nums){
        Set<Node> set = new HashSet<>();
        int res = 0;
        for(int i = 0; i < nums.length /2; i++){
            if(nums[i] != nums[i + nums.length /2]) {
                set.add(new Node(nums[i], nums[i + nums.length / 2]));
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++){
            nums[i] = in.nextInt();
        }
        System.out.println(fun(nums));


        char g = 'g';
        String str = Character.toString(g);
        System.out.println(str);
        str = String.valueOf(str);
        System.out.println(str);
    }
}
