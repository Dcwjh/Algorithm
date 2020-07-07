package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ZUOSHEN_BFPRT
 * @Date 2020/7/5 11:54
 * @Version 1.0
 */


public class ZUOSHEN_BFPRT {
    //用BFPRT方法得到第k个最小的值
//    public static int getMinKthByBFPRT(int[] arr,int k ){
//        int[] copyArr = copyArray(arr);
//        //得到数组中第k-1位置上的值就是第k小的值
//        return bfprt(copyArr,0,copyArr.length-1,K-1);
//    }
//    //bfprt方法主体，在bigin和end范围上求第i小的数
//    public static int bfprt(int[] arr,int begin,int end,int i){
//        if(begin == end){
//            return arr[begin];
//        }
//        //求中位数的中位数
//        int pivot = medianOfMedians(arr,begin,end);
//        //求完第二轮的中位数之后就开始进行划分
//        int[] privotRange = partition(arr,begin,end,pivot);
//        //正好i位置等于相等部分则返回
//        if(i>= pivotRange[0] && i <= pivotRange[1]){
//            return arr[i];
//            //i小于排序起始位置的情况，走左边
//        }else if(i<pivotRange[0]){
//            return bgprt(arr,begin,pivotRange[0]-1,i);
//        }else{
//            //i大于终止位置的情况，走右边
//            return bfprt(arr,pivotRange[1]+1,end,i);
//        }
//    }
//
//    public static int medianOfMedians(int[] arr,int begin,int end){
//        int num = end - begin +1;
//        int offset = num % 5 == 0 ? 0:1;
//        int[] marr = new int[num/5+offest];
//        for(int i = 0;i<mArr.length;i++){
//            int beginI = begin + i*5;
//            int endI = beginI +4;
//            mArr[i] = getMedian(arr,beginI,Math.min(end,endI));
//        }
//        return bfprt(mArr,0,mArr.length-1,mArr.length/2);
//    }
//
//    //partition是实现荷兰国旗问题，将大于小于等于三类划分开
//    public static int[] partition(int[] arr,int begin,int end,int privotValue){
//        int small = begin -1;
//        int cur = begin;
//        int big = end+1;
//        while(cur != big){
//            if(arr[cur]< pivotValue){
//                swap(arr,++small,cur++);
//            }else if(arr[cur]>pivotValue){
//                swap(arr,cur,--big);
//            }else{
//                cur++;
//            }
//        }
//        //range返回两个值，第一个是起始位置，第二个是排序的终止位置
//        int[] range = new int[2];
//        range[0] = small+1;
//        range[1] = big-1;
//        return range;
//    }
}
