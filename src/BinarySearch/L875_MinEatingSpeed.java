package BinarySearch;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L875_MinEatingSpeed
 * @Date 2021/7/9 9:19
 * @Version 1.0
 */


public class L875_MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length - 1];
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(possible(mid, piles, h)){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean  possible(int mid, int [] pile, int h){
        int count = 0;
        for(int i = 0; i < pile.length; i++){
            if(pile[i] <= mid){
                count ++;
            } else{
                count += (pile[i] + mid - 1) / mid;
            }
        }
        return count <=h ? true:false;
    }
}
