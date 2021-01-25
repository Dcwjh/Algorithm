package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC73
 * @Date 2021/1/24 18:17
 * @Version 1.0
 */


public class NC73 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0) return 0;
        if(array.length == 1) return array[0];
        int count = 0;
        int num = 0;
        int index = 0;
        while(index < array.length){
            if(count == -1){
                num = array[index];
                count = 1;
            } else if( num == array[index]){
                count ++;
            }else{
                count --;
            }
            index ++;
        }
        if(count<1) return 0;
        count = 0;
        for(int i = 0; i < array.length;i++){
            if(num==array[i]){
                count++;
            }
            if(count > array.length/2 + 1){
                return num;
            }
        }
        if(count > array.length/2 + 1) return num;
        return 0;
    }
}
