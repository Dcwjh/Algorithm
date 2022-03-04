import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName sxf3
 * @Date 2021/8/31 18:00
 * @Version 1.0
 */


public class sxf3 {
    public static ArrayList<String> merge (ArrayList<String> input) {
        String[][] nums = new String[input.size()][2];
        for(int i = 0; i < input.size(); i++){
            String temp = input.get(i);
            if(temp.contains("-")){
                String[] s = temp.split("-");
                nums[i][0] = s[0];
                nums[i][1] = s[1];
            } else{
                nums[i][0] = temp;
                nums[i][1] = temp;
            }
        }
        Arrays.sort(nums, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0]))
                    return o1[1].compareTo(o2[1]);
                return o1[0].compareTo(o2[0]);
            }
        });

        ArrayList<String[]> res = new ArrayList<>();
        String[] s1 = new String[2];
        s1[0] = nums[0][0];
        s1[1] = nums[0][1];
        res.add(s1);
       // System.out.println(res.get(0)[0] + "-" + res.get(0)[1]);
        for(int i = 1; i < nums.length; i++){
            String[] temp = res.get(res.size() - 1);
            //System.out.println(temp[1]);
            if(compare(nums[i][0],temp[1])) //如果下一个开始大于末尾
            {
                //重新加入
                //System.out.println("比较结果nums1：" + nums[i][0]);
               // System.out.println("比较结果temp：" + temp[1]);
                String[] a = new String[]{nums[i][0], nums[i][1]};
                res.add(a);
            } else{
                if(compare(nums[i][1], temp[1])){
                    temp[1] = nums[i][1];
                }
            }
            //System.out.println(res.get(res.size() - 1)[0] + "-" + res.get(res.size() - 1)[1]);
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < res.size(); i++){
            String[] temp = res.get(i);
            if(temp[0].equals(temp[1])){
                list.add(temp[0]);
            } else{
                list.add(temp[0] + "-" + temp[1]);
            }
        }
        return list;
    }

    private static boolean compare(String s1, String s2){
        String[] str1 = s1.split("\\.");
        String[] str2 = s2.split("\\.");
        for(int i = 0; i < str1.length; i ++){
            if(Integer.parseInt(str1[i]) > Integer.parseInt(str2[i]))
                return true;
            if(Integer.parseInt(str1[i]) < Integer.parseInt(str2[i]))
                return false;
        }
        return true;
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

        ArrayList<String> str = merge(test);
        for(String s : str){
            System.out.println( str);
        }
    }


}
