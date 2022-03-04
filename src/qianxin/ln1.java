package qianxin;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln1
 * @Date 2021/9/23 15:51
 * @Version 1.0
 */


public class ln1 {
    public int DoPermute (int M, int N) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < N + 1; i++){
            list.add(i);
        }
        int count = list.size();
        int i = -1;
        while(count > 1){
            int temp = i + M;
            temp = temp % count;
            list.remove(temp);
            count--;
            i = --temp;
            M++;
        }
        return list.get(0);
    }
}
