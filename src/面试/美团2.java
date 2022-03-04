package 面试;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName 美团2
 * @Date 2021/8/8 10:21
 * @Version 1.0
 */


public class 美团2 {
    public static String fun(String s){
        String[] str = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for(String temp : str){
            sb.append(temp);
        }
        char temp = sb.charAt(0);
        for(int i = 1; i < sb.length(); i++){
            //去重处理
        }
        return "";
    }
}
