import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Solutions3
 * @Date 2021/7/25 20:05
 * @Version 1.0
 */


public class Solutions3 {
    private static int fun(int a, int b, int c, int q,  int res){
        if(res == 1) return 1;
        if(c == 1 ){
            if(q%b == a)
                return 1;
            else{
                return 0;
            }
        }
        if(q % b == a % b) {
            return 1;
        }
        if(a > q) return 0;
        res = fun(a + b,b, c,q,res);
        res = fun(a *c,b,c,q,res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int q = sc.nextInt();
            System.out.println(fun(a,b,c,q,0));
        }
    }

    public List<Integer> fun(int label){
        List<Integer> res = new ArrayList<>();
        int index = 1;
        int min = 1;
        int max = 1;
        List<Integer> tmp = new ArrayList<>();
        int posIndex = -1;
        int posTarget = -1;
        boolean flag = false;
        while( max < 2*label){
            // 偶数层
            if(index%2 == 0){
                // 倒序插入
                for(int i=max;i>=min;i--){
                    tmp.add(i);
                    posIndex++;
                    if(i==label){
                        posTarget = posIndex;
                        flag = true;
                    }
                    if(flag) break;
                }
            }else{
                // 正序插入
                for(int i=min;i<=max;i++){
                    tmp.add(i);
                    posIndex++;
                    if(i==label){
                        posTarget = posIndex;
                        flag = true;
                    }
                    if(flag) break;
                }
            }
            min = 2*min;
            max = 2*max + 1;
            index++;
        }
        posTarget = posTarget+1;
        while(posTarget != 0){
            res.add(tmp.get(posTarget-1));
            posTarget = posTarget/2;
        }
        List<Integer> ans = new ArrayList<>(res.size());
        for(int i=res.size()-1;i>=0;i-- ){
            ans.add(res.get(i));
        }
        return ans;
    }
}
