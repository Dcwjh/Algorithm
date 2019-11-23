package Array;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName merge_56
 * @Date 2019/11/14 0:10
 * @Version 1.0
 */


public class merge_56 {
    public static int[][] merge(int[][] intervals){
        if(intervals == null || intervals.length == 1)
            return intervals;
        int len = 0;
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i][1] >= intervals[i+1][0]){
                i++;
            }
            len++;
        }
        if(intervals[intervals.length - 2][1] < intervals[intervals.length - 1][0]){
            len++;
        }
        System.out.println(len);

        int[][] merger = new int[len][intervals[0].length];
        for(int i = 0,j = 0; i < merger.length - 1; i++,j++){
            if(intervals[i][1] >= intervals[i+1][0]){
                merger[j][0] = Math.min(intervals[i][0], intervals[i+1][0]);
                merger[j][1] = Math.max(intervals[i][1], intervals[i+1][1]);
                i++;
            }else{
                merger[j][0] = intervals[i][0];
                merger[j][1] = intervals[i][1];
            }
        }
//        if(intervals[intervals.length - 2][1] < intervals[intervals.length - 1][0])
//        {
//            merger[len - 1][0] = intervals[intervals.length - 1][0];
//            merger[len - 1][1] = intervals[intervals.length - 1][1];
//        }
//        else{
//            merger[len - 1][0] = intervals[intervals.length - 2][0];
//            merger[len - 1][0] = intervals[intervals.length - 1][1];
//        }
        return merger;

    }

    public static void main(String[] args) {
        int[][]  intverals = new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        System.out.println(Arrays.deepToString(merge(intverals)));
    }
}
