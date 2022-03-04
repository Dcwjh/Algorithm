import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName sxf1
 * @Date 2021/8/31 16:54
 * @Version 1.0
 */


public class sxf1 {

    public static  ArrayList<String> merge (ArrayList<String> input) {
        // write code here
        String[][] nums = new String[input.size()][2];

        for(int i = 0; i < input.size(); i++){
            String temp = input.get(i);
            if(temp.contains("-")){
                String[] str = temp.split("-");
                nums[i][0] = str[0];
                nums[i][1] = str[1];
            } else {
                nums[i][0] = temp;
                nums[i][1] = temp;
            }
        }

        Arrays.sort(nums, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o1[0])){
                    return o1[1].compareTo(o2[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });
        System.out.println("==========================");
        for(int i = 0 ; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++){
                System.out.print(nums[i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println("==========================");

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        String start = nums[0][0];
        String end = nums[0][1];
        ArrayList<String> temp = new ArrayList<>();
        temp.add(start);
        temp.add(end);
        res.add(temp);
        for(int i = 1; i < nums.length; i++){
            ArrayList<String> t = res.get(res.size() - 1);
            start = t.get(0);
            end = t.get(1);
            if(Long.parseLong(nums[i][0]) > Long.parseLong(end)){
                ArrayList<String> temp1 = new ArrayList<>();
                temp1.add(nums[i][0]);
                temp1.add(nums[i][1]);
                res.add(temp1);
            } else{
                if(Long.parseLong( nums[i][1]) <= Long.parseLong(end)){
                    continue;
                } else {
                    t.set(1, nums[i][1]);
                }
            }

        }

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < res.size();i++){
            String string = ParseString(res.get(i));
            list.add(string);
        }

        return list;
    }

    public static String ParseString(ArrayList<String> nums){
        String start = nums.get(0);
        String end = nums.get(1);
        if(start.equals(end)){
            return LongParseString(start);
        }
        return LongParseString(start) + "-" + LongParseString(start);
    }

    public static String LongParseString(String nums){

        String str = nums;
        String[] s = new String[4];
        s[0] = str.substring(0,3);

        s[1] = str.substring(3,6);

        s[2] = str.substring(6,9);

        s[3] = str.substring(9,12);

        for(int i = 0; i < 4; i ++){
            if(s[i].charAt(0) == '0'){
                s[i] = s[i].substring(1,3);

                if(s[i].charAt(0) == '0'){
                    s[i] = s[i].substring(1,2);
                }
            }

        }


        return s[0] +  "." + s[1]  +  "."  + s[2]  +  "."  + s[3];
    }




    //把IP转换成long
    public static long StringParseLong(String str){
        String[] s = str.split("\\.");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length;i++){
            sb.append(String.format("%3s", s[i]).replace(" ", "0"));
        }

        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {

        ArrayList<String> test = new ArrayList<>();

        test.add("192.168.0.1");
        test.add("192.168.0.12-192.168.0.15");

        test.add("192.168.0.7-192.168.0.9");
        test.add("192.168.0.11");
        test.add("192.168.0.3-192.168.0.5");
        test.add("0.0.0.0-255.255.255.255");
        test.add("192.168.0.16");



        ArrayList<String> res =  merge(test);
        System.out.println("=========================");
        for(String s : res){
            System.out.println(res);
        }

    }
}
//["192.168.0.1", "192.168.0.12-192.168.0.15", "192.168.0.2", "192.168.0.7-192.168.0.9", "192.168.0.11", "192.168.0.3-192.168.0.5", "0.0.0.0-255.255.255.255","192.168.0.16", "192.168.0.100"]
//
//
//    ["0.0.0.0-255.255.255.255"]
//
//
//    ["192.168.1.1","192.168.1.2","92.168.20.3-92.168.20.3"]
//
//    ["92.168.20.3","192.168.1.1-192.168.1.2"]
