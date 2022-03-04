import java.util.HashMap;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName HuaWei
 * @Date 2021/9/24 16:31
 * @Version 1.0
 */


public class HuaWei {
    private static int fun(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put((char)('A' + i), i + 1);
        }
        char[] ch = str.toCharArray();
        int sum = 0;
        for(int i = ch.length - 1; i >= 0; i--){
            sum = sum * 26  + map.get(ch[i]);

        }
        return sum;
    }
    //'AA'
    public static void main(String[] args) {

    }
}
