package quna;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln
 * @Date 2021/9/14 17:43
 * @Version 1.0
 */


public class ln {
    public static String solution(int[] d) {
        Arrays.sort(d);
        int[] help = new int[d.length];
        for(int i = 0; i < d.length; i++){
            help[i] = d[i] % 3;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = d.length - 1; i >= 0; i--){
            if(help[i] == 0){
                help[i] = -1;
                list.add(d[i]);
            } else if(help[i] == 2){
                for(int j = i - 1; j >=0; j--){
                    if(j >= 0 && help[j] == 1){
                        help[i] = -1;
                        help[j] = -1;
                        list.add(d[i]);
                        list.add(d[j]);
                    }
                }
            } else { //找两个1
                int c1 = -1;
                int c2 = -1;
                for(int j = i - 1; j >= 0; j--){
                    if(j >= 0 && help[j] == 1){
                        if(c1 == -1){
                            c1 = j;
                        } else {
                            c2 = j;
                            break;
                        }
                    }
                }
                if(c1 != -1 && c2!= -1) {
                    list.add(d[i]);
                    list.add(d[c1]);
                    list.add(d[c2]);
                    help[i] = -1;
                    help[c1] = -1;
                    help[c2] = -1;
                } else { //找不到1就去找2
                    for(int j = i - 1; j >=0; j--){
                        if(j >= 0 && help[j] == 2){
                            help[i] = -1;
                            help[j] = -1;
                            list.add(d[i]);
                            list.add(d[j]);
                        }
                    }

                }
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        StringBuilder sb = new StringBuilder();
       for(Integer temp : list)
            sb.append(temp);
        return sb.toString();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,5,6,7};
        System.out.println(solution(nums));
    }
}
