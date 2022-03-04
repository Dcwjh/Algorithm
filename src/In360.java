import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName In360
 * @Date 2021/8/29 15:44
 * @Version 1.0
 */


public class In360 {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        //学生个数
//        int n = in.nextInt();
//        int p = in.nextInt(); //平时成绩
//        int q= in.nextInt();
//
//        int[] students = new int[n];
//        for(int i = 0; i < students.length; i++){
//            students[i] = in.nextInt();
//        }
//        System.out.println(fun(p,q,students));
//
//    }

//    private static int fun(int p, int q, int[] nums){
//        Arrays.sort(nums);
//        int n = nums.length;
//        int[] score = new int[n];
//        int full = 100;
//
//        score[n - 1] = 100;
//        int temp = nums[n - 1];
//        for(int i = n - 2; i >= 0; i--){
//            if(nums[i] == temp){
//                score[i] = score[i + 1];
//            } else{
//                full--;
//                score[i] = full;
//                temp = nums[i];
//            }
//        }
//
//        int[] finalscore = new int[n];
//        for(int i = 0; i < n; i++){
//            finalscore[i] = p * score[i] + q * nums[i];
//        }
////        System.out.print("考试分数：");
////        print(nums);
////        System.out.print("平时分数：");
////        print(score);
////        System.out.print("最终分数：");
////        print(finalscore);
//        int res = 0;
//        for(int i = 0; i < n; i++){
//            if(finalscore[i] >= 6000){
//                res ++;
//            }
//        }
//        return res;
//    }


    private  static void print(int[] nums){
        for(int num:nums){
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //烽火台个数
        int n = in.nextInt();
        //将军个数
        int m = in.nextInt(); //平时成绩
        //影响范围
        int x = in.nextInt();
        //提升战力
        int k = in.nextInt();

        int[] soldiers = new int[n];
        for(int i = 0; i < soldiers.length; i++){
            soldiers[i] = in.nextInt();
        }
        System.out.println(fun(m,x,k,soldiers));
    }
    static int res = 0;
    private static int fun(int m, int x, int k, int[] s){
        int min = s[0];
        for(int i : s){
            min = Math.min(min, i);
        }
        res = min;
        dfs(m, x,k,s,0);
        return res;
    }

    private static void dfs(int m, int x, int k, int[] s, int loc){
        if (m == 0) {
            res = Math.max(res, get_min(s));
            print(s);
            return;
        }
        for(int i = 0; i < s.length; i++){
            //位置添加将军
            addGener(i, x, k, s);
            dfs(m - 1,x, k, s, i);
            deleteGener(i,x,k,s);

        }
    }

    private static void addGener(int loc, int x, int k, int[] s){
        for(int i = loc - x; i <= loc + x; i++){
            if( 0<=i && i < s.length){
                s[i] += k;
            }
        }
    }

    private static void deleteGener(int loc, int x, int k, int[] s){
        for(int i = loc - x; i <= loc + x; i++){
            if( 0<=i && i < s.length){
                s[i] -= k;
            }
        }
    }

    private static int get_min(int[] nums){
        int min = nums[0];
        for(int num : nums){
            min = Math.min(num, min);
        }
        return min;
    }
}
/*
5 2 1 2
4 4 2 4 4
 */
