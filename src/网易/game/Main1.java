package 网易.game;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Main1
 * @Date 2021/8/28 15:05
 * @Version 1.0
 */

/*




 */


public class Main1 {


    public static void main(String[] args) {
        //输入数据
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //一共有几轮测试用力
        for(int i = 0; i < n; i ++){
            //野怪个数
            int m = in.nextInt();
            int attack = in.nextInt();
            int def = in.nextInt();
            int[][] mons = new int[m][3];
            for(int j = 0; j < m; j++){
                mons[j][0] = in.nextInt(); //攻击力
                mons[j][1] = in.nextInt(); //防御力
                mons[j][2] = in.nextInt(); //胜利力
            }
            System.out.println(fun(attack, def, mons));

        }
    }

    private static int fun(int attack, int def, int[][] mons){

        int n = mons.length;
        //主角的攻击力必须大于怪物的防御力， mons才能被打死
        for(int i = 0; i < n; i++){
            if(attack <= mons[i][1])
                return -1;
        }
        int all = 0;
        int life = mons[0][0] - def + 1;
        int temp = life;
        for(int i = 0; i < n; i++){
            while(mons[i][2] > 0){
                int temp1 = attack - mons[i][1]; //怪物掉的血
                //怪物还活着
                if(temp1 < mons[i][2]) {
                    int temp2 = mons[i][0] - def; //主角掉的血, 大于才掉血
                    if (temp2 > 0) temp -= temp2;
                    if(temp <= 0) {
                        life = life - temp + 1;
                        temp = 1;
                    }
                }
                mons[i][2] -= temp1;
               // System.out.println("temp1:" + temp1 + " mons[i][2]；" + mons[i][2]);
            }
            temp += (-mons[i][2]);
            //System.out.println("life:" + life + "   temp:" + temp +  " mons[i][2]:" + mons[i][2]);

        }
        return life;
    }
}

/*
1
3
10 5
10 5 6
10 5 7
10 5 8

 */
