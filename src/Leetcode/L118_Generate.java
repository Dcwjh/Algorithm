package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Generate_118
 * @Date 12/7/2020 9:39 AM
 * @Version 1.0
 */


public class L118_Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j ==i){
                    list.add(1);
                } else{
                    list.add(result.get(i -1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }
        return result;

    }
}
