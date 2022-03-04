package tushen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln2
 * @Date 2021/9/18 19:59
 * @Version 1.0
 */


public class ln2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String[] line1s = line1.split(" ");
        int m = Integer.parseInt(line1s[0]);
        int n = Integer.parseInt(line1s[1]);
        String[] input = new String[n];
        for(int i = 0; i < n; i++){
            input[i] = in.nextLine();
        }
        HashMap<String, Integer> map = new HashMap<>();
        int[][] nums = new int[m][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j ++){
                nums[i][j] = i == j? 0: Integer.MAX_VALUE / 2;
            }
        }

        int index = 0;
        for(int i = 0; i < input.length; i++){
            String[] temp = input[i].split(" ");
            if(!map.containsKey(temp[0])){
                map.put(temp[0], index++);
            }
            if(!map.containsKey(temp[1])){
                map.put(temp[1], index++);
            }
            nums[map.get(temp[0])][map.get(temp[1])] = Integer.parseInt(temp[2]);

        }
        int k = Integer.parseInt(in.nextLine());
        for(int i = 0; i < k; i++){
            String[] temp = in.nextLine().split(" ");
            int a = map.get(temp[0]);
            int b = map.get(temp[1]);
            fun(nums, a, b);
        }
    }

    private static void fun(int[][] nums, int k, int b){
        int n = nums.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE/2);
        dist[k] = 0;
        for(int p = 0; p < n; p++){
            int t = -1;
            for(int i = 0; i < n; i ++){
                if(!visited[i] && (t== -1 || dist[i] < dist[t])) t = i;
            }
            visited[t] = true;
            for(int i = 0; i < n; i++){
                dist[i] = Math.min(dist[i], dist[t] + nums[t][i]);
            }
        }
        if(dist[b] >= Integer.MAX_VALUE / 2)
            System.out.println("INF");
        else System.out.println(dist[b]);
    }
}

/*

3 2
novak goat 1
goat simulator 3
2
novak simulator
simulator goat
 */