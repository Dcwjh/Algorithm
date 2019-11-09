package DP;

/**
 * @Description 给定$n$个活动，活动$a_i$表示为一个三元组$(s_i,f_i,v_i)$，其中$s_i$表示活动开始时间，
 * $f_i$表示活动的结束时间，$v_i$表示活动的权重。带权活动选择问题是选择一些活动，
 * 使得任意被选择的两个活动$a_i$和$a_j$执行时间互不相交，即区间$[s_i,f_i]$与$[s_j,f_j]$互不重叠，并
 * 且被选择的活动的权重和最大。请设计一种方法求解带权活动选择问题。
 * @Author Jianhai Wang
 * @ClassName ActivityChoose
 * @Date 2019/11/9 10:14
 * @Version 1.0
 */
/*
算法思路：
采用动态规划自下而上的方式求解

设问题的最优解为opt[n], 其物理意义为前n个区间所能构成的最大权值和。最优解求解公式为：
$$opt(n) = max(opt(n - 1),opt(pre[i] + v[i]))$$
其中，pre[i]表示第i个区间之前与它最近且不相交的区间，v[i]为区间i的权值，可以利用pre[i]从pre[n]向前推出所选择的区间。
*/

public class ActivityChoose {
    public static class Activity{
        int start;
        int end;
        int value;
        public Activity(int start,int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
    public static void choose(Activity[] activities){ //活动下标从1开始
        int[] pre = new int[activities.length]; //记录前一个可行的活动下标
        int[] record = new int[activities.length]; //记录选择的活动
        pre[1] = 0;
        for(int i = 1; i < activities.length;i++){
            pre[i] = 0;
            for(int j = i - 1; j > 0; j--){
                if(activities[j].end <= activities[i].start){
                    pre[i] = j;
                    break;
                }
            }
        }
        //开始DP
        int[] dp = new int[activities.length];
        dp[0] = 0;
        for(int i = 1;i < activities.length; i++){
            if(dp[i -1] < dp[pre[i]] + activities[i].value) {
                dp[i] = dp[pre[i]] + activities[i].value;
                record[i] = 1;
            }else{
                dp[i] = dp[i - 1];
                record[i] = 0;
            }
        }
        int n = activities.length - 1;
        while(n!=0){
            if(record[n] != 0) {
                System.out.println("活动" + n + ": " + activities[n].start + " --- " + activities[n].end + "   value: " + activities[n].value);
                n = pre[n];
            }else{
                n--;
            }
        }
        System.out.println(dp[activities.length - 1]);
    }


    public static void main(String[] args) {
        Activity[] activities = new Activity[9];
        activities[1] = new Activity(1,4,5);
        activities[2] = new Activity(3,5,1);
        activities[3] = new Activity(0,6,8);
        activities[4] = new Activity(4,7,4);
        activities[5] = new Activity(3,8,6);
        activities[6] = new Activity(5,9,3);
        activities[7] = new Activity(6,10,2);
        activities[8] = new Activity(8,11,4);
        System.out.println("===============活动列表===================");
        System.out.format("%-7s %-7s %-7s %-7s", "活动","start","end","value");
        System.out.println();
        for(int i = 1; i < activities.length; i++){
            System.out.println( "任务" + i + "      " + activities[i].start + "        " + activities[i].end + "       " + activities[i].value);
        }
        System.out.println("==========================================");
        choose(activities);

    }
}
