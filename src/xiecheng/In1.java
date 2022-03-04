package xiecheng;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName In1
 * @Date 2021/9/9 19:02
 * @Version 1.0
 */

/*
你需要编写一个程序来模拟目录的操作，一开始，你在根目录"\"，一共有两种命令：

● cd s: s为一个目录名，表示从当前工作目录的路径进入名为s的目录。特别地，"cd .."(即s=="..")表示返回上一级目录，若当前已为根目录，则无视该次操作。数据保证若s不为".."，则一定为小写字母组成的长度不超过10的字符串。

● pwd: 表示查看当前工作目录的路径，你需要输出这个路径。




第一个行是一个整数n，表示一共会有n个操作。

接下来每行是一条命令，命令的种类为问题描述中的二种之一。

注意，测试用例中cd s的操作，中间有空格。



对于每个"pwd"命令，你需要单行输出当前的工作路径



7
cd a
cd b
pwd
cd ..
pwd
cd ..
pwd



\a\b
\a
\
 */
public class In1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] strings = new String[n];
        for(int i = 0; i < n; i++){
            strings[i] = in.nextLine();
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("\\");
        for(int i = 0; i < n; i++){
            String temp = strings[i];
            String[] instruct = temp.split(" ");
            if(instruct[0].equals("cd")){
                if(instruct[1].equals("..")) {
                    if(list.size() > 1) {
                        list.remove(list.size() - 1);
                    }
                } else{
                    list.add(instruct[1]);
                }
            } else{
                print(list);
            }
        }


    }

    private static void print(ArrayList<String> list){
        StringBuilder sb = new StringBuilder();
        if(list.size() == 1){
            System.out.println("\\");
            return;
        }
        for(int i = 1; i < list.size(); i ++){
            sb.append("\\" + list.get(i));
        }
        System.out.println(sb.toString());
    }
}
