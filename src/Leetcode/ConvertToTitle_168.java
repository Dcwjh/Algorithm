package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ConvertToTitle_168
 * @Date 12/9/2020 3:36 PM
 * @Version 1.0
 */


public class ConvertToTitle_168 {
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            n--; //因为 Excel 取值范围为 1~26，故可将 26 进制 逻辑上的 个位、十位、百位…均减 1 映射到 0~25 即可，最后转换为字符
            sb.append((char)('A' + (n)%26 ));
            n = n/26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));

    }
}
