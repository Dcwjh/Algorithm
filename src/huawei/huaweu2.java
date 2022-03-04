package huawei;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName huaweu2
 * @Date 2021/9/1 19:11
 * @Version 1.0
 */


public class huaweu2 {

    /*
3
student subClassOf person
Tom instanceOf student
Marry instanceOf person
person
     */
    private static void fun(String[] str, String name){
        if(str.length == 0) {
            System.out.println("empty");
            return;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < str.length; i++){
            String temp = str[i];
            String[] s = temp.split(" ");
            if(map.containsKey(s[2])){
                List<String> l = map.get(s[2]);
                l.add(s[0] + " " + s[1]);
            }else{
                List<String> list = new ArrayList();
                list.add(s[0] + " " + s[1]);
                map.put(s[2],list);
            }

        }
        //保存结果
        List<String> ans = new ArrayList<>();
        List<String> subclas = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if(map.containsKey(name)){
            List<String> res = map.get(name);
            //取出实例
            for(String tem : res){
                String[] s1 = tem.split(" ");
                if(s1[1].equals("instanceOf")){

                        ans.add(s1[0]);

                } else{
                    subclas.add(s1[0]);
                }
            }
            set.add(name);
        } else {
            System.out.println("empty");
            return;
        }

        while(true){
            int size = subclas.size();
            for(int i = 0; i < size; i++){
                String s1 = subclas.get(i);
                if(map.containsKey(s1)){
                    List<String> l1 = map.get(s1);
                    for(String tem : l1){
                        String[] s2 = tem.split(" ");
                        if(s2[1].equals("instanceOf")){
                            ans.add(s2[0]);
                        } else{
                            subclas.add(s2[0]);
                        }
                    }
                }
                set.add(s1);
            }

            for(String s3 : set){
                if(subclas.contains(s3)){
                    subclas.remove(s3);
                }
            }
            if(subclas.size() == 0)
                break;
        }

        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        if(ans.size() == 0) System.out.println("empty");
        for(String s: ans){
            System.out.print(s  + " ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ns = in.nextLine();
        int n = Integer.parseInt(ns);
        String[] str = new String[n];
        for(int i= 0; i < n; i++){
            str[i] = in.nextLine();
        }
        String name = in.nextLine();
        fun(str, name);

    }
}
