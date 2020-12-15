package Leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName MaxNumber_321
 * @Date 12/2/2020 4:47 PM
 * @Version 1.0
 */


public class L321_MaxNumber {

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        //利用单调栈思想，先将两个数组合并，然后求出最大数

        //出错了，想法虽好，但是还需要考虑相对位置
        int[] help = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2])
                help[i++] = nums1[p1++];
            else
                help[i++] = nums2[p2++];
        }
        while (p1 < nums1.length)
            help[i++] = nums1[p1++];
        while (p2 < nums2.length)
            help[i++] = nums2[p2++];
        if (k == help.length)
            return help;
        Stack<Integer> stack = new Stack<>();  //递减栈
        k = help.length - k;
        for (i = 0; i < help.length; i++) {
            //如果下一个比当前栈顶大
            while (!stack.isEmpty() && stack.peek() < help[i] && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(help[i]);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        int[] result = new int[stack.size()];
        i = result.length - 1;
        while (!stack.isEmpty())
            result[i--] = stack.pop();
        return result;

    }

    //选位置算法，两个辅助数组,想法很好，实现很难，难以处理边界情况
    public static int[] maxNumber2(int[] nums1, int[] nums2, int k) {
        //第一步，稳定排序保留下标进辅助数组（位置很重要）
        int[] help1 = sort(nums1);  //相对顺序，他是下标
        int[] help2 = sort(nums2);
        int[] result = new int[k];
        int len = nums1.length + nums2.length;
        int i = 0;
        int p1 = 0;
        int remain1 = nums1.length;
        int p2 = 0;
        int remain2 = nums2.length;


        //第二步，刷选数组中数据,选出最大的数字且符合条件
        while (k > 0) {
            if (p1 == nums1.length || p2 == nums2.length) break;
            int m = help1[p1];
            int n = help2[p2];
            if (nums1[m] > nums2[n]) {
                if (nums1.length - m + remain2 >= k) {
                    remain1 = nums1.length - help1[p1] - 1;
                    result[i++] = nums1[m];
                    p1++;
                    k--;
                    while (p1 < nums1.length && help1[p1] < m) p1++; //选中非递减

                } else {
                    p1++;
                }

            } else {
                if (nums2.length - n + remain1 >= k) {
                    remain2 = nums2.length - help2[p2] - 1;
                    result[i++] = nums2[n];
                    p2++;
                    k--;
                    while (p2 < nums2.length && help2[p2] < n) p2++;

                } else {
                    p2++;
                }

            }


        }
        System.out.println(p1 + " " + p2);
        return result;

    }


    //单调栈，配合数组
    public static int[] last(int[] nums1, int[] nums2, int k) {
        int[] help1 = new int[10];
        int[] help2 = new int[10];
        int[] result = new int[k];
        for (int i = 0; i < nums1.length; i++) {
            help1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            help2[nums2[i]]++;
        }

        int i = 0;
        k = nums1.length + nums2.length - k;
        while (k > 0) {
            if (help1[i] == 0 && help2[i] == 0) {
                i++;
                continue;
            }
            int index1 = 0;
            int index2 = 0;
            if (help1[i] != 0 && help2[i] != 0) {
                while (index1 < nums1.length && nums1[index1] != i) index1++;
                while (index2 < nums2.length && nums2[index2] != i) index2++;
                if (nums1.length - index1 > nums2.length - index2) {
                    nums1[index1] = -1;
                    help1[i]--;
                } else if (nums1.length - index1 < nums2.length - index2) {
                    nums2[index2] = -1;
                    help2[i]--;
                } else {
                    int temp = 1;
                    while (temp + index1 < nums1.length) {
                        if (nums1[temp + index1] < nums2[temp + index2]) {
                            nums1[index1] = -1;
                            help1[i]--;
                            break;
                        } else if (nums1[temp + index1] > nums2[temp + index2]) {
                            nums2[index2] = -1;
                            help2[i]--;
                            break;
                        } else
                            temp++;
                    }
                    if (temp + index1 == nums1.length) {
                        nums1[index1] = -1;
                        help1[i]--;
                    }
                }
            } else if (help1[i] != 0) {
                while (index1 < nums1.length && nums1[index1] != i) index1++;
                nums1[index1] = -1;
                help1[i]--;
            } else if (help2[i] != 0) {
                while (index2 < nums2.length && nums2[index2] != i) index2++;
                nums2[index2] = -1;
                help2[i]--;
            }
            k--;
        }


        //合并
        i = 0;
        int index1 = 0;
        int index2 = 0;
        while (i < result.length) {
            while (index1 < nums1.length && nums1[index1] == -1) index1++;
            while (index2 < nums2.length && nums2[index2] == -1) index2++;
            if (index1 == nums1.length) {
                result[i++] = nums2[index2++];
            } else if (index2 == nums2.length) {
                result[i++] = nums1[index1++];
            } else if (nums1[index1] > nums2[index2]) {
                result[i++] = nums1[index1++];
            } else if (nums1[index1] < nums2[index2])
                result[i++] = nums2[index2++];
            else {
                boolean flag = true;
                int temp = 0;
                while (temp + index1 < nums1.length) {
                    if (nums1[index1 + temp] < nums2[index2 + temp]) {
                        flag = false;
                        break;
                    } else if (nums1[index1 + temp] > nums2[index2 + temp])
                        break;
                    else
                        temp++;

                }
                if (flag)
                    result[i++] = nums1[index1++];
                else
                    result[i++] = nums2[index2++];
            }

        }
        return result;
    }

   //思想：统计数，然后先选择满足条件得最大数.   放弃了，特殊情况太多了。简单点吧，就是分k种情况，然后在比较
    public static int[] maxNum(int[] nums1, int[] nums2, int k) {
        int[] help1 = new int[10];
        int[] help2 = new int[10];
        int[] result = new int[k];
        for (int i = 0; i < nums1.length; i++) {
            help1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            help2[nums2[i]]++;
        }
        int index1 = -1;
        int index2 = -1;
        int remain1 = nums1.length;
        int remian2 = nums2.length;
        int t = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < 10; i++){
            if(help1[i] != 0 || help2[i] != 0)
                s.push(i);
        }
        int temp;
        while (k > 0) {
            temp = s.peek(); //temp必定是存在的。
            boolean flag1 = true;
            boolean flag2 = true;
            if(help1[temp] != 0 && help2[temp] != 0){  //两者都有
                int t1 = index1 + 1;
                int t2 = index2 + 1;
                while(t1 < nums1.length && nums1[t1] != temp) t1++;
                while(t2 < nums2.length && nums2[t2] !=temp) t2++;
                if(index1 > t1 || t1 == nums1.length) flag1 = false;
                if(index2 > t2 || t2 == nums2.length) flag2 = false;
                if(t1 == nums1.length - 1 && t2 == nums2.length - 1){ //最后一个相同
                    int inc = 1;
                    while(index1 + inc < nums1.length && index2 + inc < nums2.length)
                        if(nums1[index1 + inc] > nums2[index2 + inc]) {
                            flag1 = false;
                            break;
                        }
                        else if(nums1[index1 + inc] < nums2[index2 + inc]) {
                            flag2 = false;
                            break;
                        }
                        else inc++;

                }
                if(flag1 && flag2){
                        int inc = 1;
                        boolean flag = true;
                        while(t1 + inc < nums1.length )
                            if (nums1[inc + t1] < nums2[inc + t2]) {
                                flag = false;
                                break;
                            }
                            else inc++;
                        if(flag){
                            help1[temp]--;
                            result[t++] = temp;
                            nums1[t1] = -1;
                            index1 = t1;
                            k--;
                            remain1 = nums1.length - index1 - 1;
                        }else{
                            help2[temp]--;
                            result[t++] = temp;
                            nums2[t2] = -1;
                            index2 = t2;
                            k--;
                            remian2 = nums2.length - index2 - 1;
                        }
                        int m  = s.pop();
                        Stack<Integer> stack = new Stack<>();
                        while(!s.isEmpty()&& s.peek() > m) stack.push(s.pop());
                        s.push(m);
                        while(!stack.isEmpty()) s.push(stack.pop());
                }
                else if(flag1){
                    help1[temp]--;
                    result[t++] = temp;
                    nums1[t1] = -1;
                    index1 = t1;
                    k--;
                    remain1 = nums1.length - index1 - 1;
                } else{
                    help2[temp]--;
                    result[t++] = temp;
                    nums2[t2] = -1;
                    index2 = t2;
                    k--;
                    remian2 = nums2.length - index2 - 1;
                }
            } else if(help1[temp] != 0 ){ //help
                int t1 = 0;
                while(nums1[t1] != temp) t1++;
                if(t1 < index1){
                    s.pop();
                    continue;
                }
                if(remian2 + nums1.length - t1 >= k){ //符合条件
                    help1[temp]--;
                    result[t++] = temp;
                    nums1[t1] = -1;
                    index1 = t1;
                    k--;
                    remain1 = nums1.length - index1 - 1;
                    if(help1[temp] == 0)
                        s.pop();
                    if(!s.isEmpty()) {
                        int m = s.pop();
                        Stack<Integer> stack = new Stack<>();
                        while (!s.isEmpty() && s.peek() > m) stack.push(s.pop());
                        s.push(m);
                        while (!stack.isEmpty()) s.push(stack.pop());
                    }
                } else{
                    Stack<Integer> stack = new Stack<>();
                    int m = s.pop();
                    while(!s.isEmpty() && s.peek() > m) stack.push(s.pop());
                    stack.push(m);
                    if(!s.isEmpty()) m = s.pop();
                    else m = -1;
                    while(!stack.isEmpty()) s.push(stack.pop());
                    if(m!=-1) s.push(m);
                }
            } else {
                int t2 = 0;
                while(nums2[t2]!=temp) t2++;
                if(t2 < index2){
                    s.pop();
                    continue;
                }
                if(remain1 + nums2.length -t2 >= k){
                    help2[temp]--;
                    result[t++] = temp;
                    nums2[t2] = -1;
                    index2 = t2;
                    k--;
                    remian2 = nums2.length - index2 - 1;
                    if(help2[temp] == 0)
                        s.pop();
                    if(!s.isEmpty()) {
                        int m = s.pop();
                        Stack<Integer> stack = new Stack<>();
                        while (!s.isEmpty() && s.peek() > m) stack.push(s.pop());
                        s.push(m);
                        while (!stack.isEmpty()) s.push(stack.pop());
                    }
                } else{
                    Stack<Integer> stack = new Stack<>();
                    int m = s.pop();
                    while(!s.isEmpty() && s.peek() > m) stack.push(s.pop());
                    stack.push(m);
                    if(!s.isEmpty()) m = s.pop();
                    else m = -1;
                    while(!stack.isEmpty()) s.push(stack.pop());
                    if(m!=-1) s.push(m);
                }

            }
        }



//            if (help1[i] == 0 && help2[i] == 0) {
//                i--;
//            } else if (help1[i] != 0 && help2[i] != 0) {
//                int temp1 = index1;
//                int temp2 = index2;
//                while (temp1 < nums1.length && nums1[temp1] != i) temp1++;
//                while (temp2 < nums2.length && nums2[temp2] != i) temp2++;
//
//                int inc = 1;
//                boolean flag = true;
//                if (temp1 < nums1.length && temp2 == nums2.length) {
//                    flag =true;
//                } else if (temp2 < nums2.length && temp1 == nums1.length) {
//                    flag = false;
//                } else {
//                    while (temp1 + inc < nums1.length && temp2 + inc < nums1.length) {
//                        if (nums1[temp1 + inc] < nums2[index2 + inc]) {
//                            flag = false;
//                            break;
//                        } else if (nums1[temp1 + inc] > nums2[index2 + inc])
//                            break;
//                        else
//                            inc++;
//                    }
//                }
//                if (flag) {
//                    if (nums1.length + nums2.length - temp1 - index2 - 1 >= k) {
//                        help1[i]--;
//                        nums1[temp1] = -1;
//                        index1 = temp1;
//                        result[t++] = i;
//                       // i = 9; //从头再来
//                        k--;
//                    } else
//                        i--;
//                } else {
//                    if (nums1.length + nums2.length - temp2 - index1 - 1>= k) {
//                        help2[i]--;
//                        nums2[temp2] = -1;
//                        index2 = temp2;
//                        result[t++] = i;
//                        i = 9;
//                        k--;
//                    } else i--;
//                }
//
//            } else if (help1[i] != 0) {
//                int temp1 = index1;
//                while (temp1 < nums1.length && nums1[temp1] != i) temp1++;
//                if (temp1 < nums1.length && nums1.length + nums2.length - temp1 - index2 - 1 >= k) {
//                    help1[i]--;
//                    nums1[temp1] = -1;
//                    index1 = temp1;
//                    result[t++] = i;
//                    //i = 9; //从头再来
//                    k--;
//                } else
//                    i--;
//
//            } else {
//                int temp2 = index2;
//                while (temp2 < nums2.length && nums2[temp2] != i) temp2++;
//                if (temp2< nums2.length &&  nums1.length + nums2.length - temp2 - index1 -1  >= k) {
//                    help2[i]--;
//                    nums2[temp2] = -1;
//                    index2 = temp2;
//                    result[t++] = i;
//                   // i = 9;
//                    k--;
//                } else i--;
//            }

//        }
        return result;
    }

    private static int[] sort(int[] num) {
        int[] help = new int[num.length];
        int[] flag = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            help[i] = num[i];
        }
        for (int i = 0; i < num.length; i++) {
            int max = i;
            for (int j = 0; j < num.length; j++) {
                if (help[j] != -1 && help[max] < help[j]) {
                    max = j;
                }
            }
            help[max] = -1;
            flag[i] = max;
        }

        return flag;
    }

//单调栈的应用：放弃最后得倔强。选用常规方法
    public static int[] maxNumber3(int[] nums1, int[] nums2, int k) {
         int[] result = new int[k];
        int[] temp1;
        int[] temp2;
        int[] temp;
        int time = k;
        if(nums1.length >= k) {
            temp = select(nums1, k);
            result = compare(temp, result);
        }
        if(nums2.length >= k){
            temp = select(nums2,k);
            result = compare(temp,result);
        }
        while(time >= 0){
            if(nums1.length >= time && nums2.length >= k - time) {
                temp1 = select(nums1, time);
                temp2 = select(nums2, k - time);
                temp = meger(temp1, temp2);
                result = compare(temp, result);
            }
            time--;
        }
        return result;
    }

    private static int[] select(int[] nums,int k){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int[] result = new int[k];
        while(i < nums.length ){
            if(nums.length - i == k - stack.size()){
                stack.push(nums[i++]);
                continue;
            }
            if(stack.isEmpty()){
                stack.push(nums[i++]);
            }else {
                while(!stack.isEmpty()&& nums[i] > stack.peek() && nums.length - i + stack.size() > k)
                   stack.pop();
                stack.push(nums[i++]);
            }
        }
        while(stack.size() > k) stack.pop();
        for(int j = result.length - 1; j >= 0; j--){
            result[j] = stack.pop();
        }
        return result;
    }

    private static int[] compare(int[] nums1, int[] nums2){
        for(int i = 0; i < nums1.length; i ++){
            if(nums1[i] > nums2[i])
                return nums1;
            else if(nums2[i] > nums1[i])
                return nums2;
        }
        return nums1;
    }


    private static int[] meger(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0,t = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] > nums2[j]){
                result[t++] = nums1[i++];
            }else if(nums1[i] < nums2[j])
                result[t++] = nums2[j++];
            else{
                int inc = 1;
                boolean flag = true;
                while(inc + i < nums1.length && inc + j < nums2.length) {
                    if (nums1[i + inc] < nums2[inc + j]) {
                        flag = false;
                        break;
                    } else if(nums1[i + inc] > nums2[inc + j]) break;
                    inc ++;
                }
                if(j == nums2.length - 1) flag = true;
                if(i == nums1.length - 1) flag = false;
                if(flag)
                    result[t++] = nums1[i++];
                else
                    result[t++] = nums2[j++];
            }

        }
        while(i < nums1.length) result[t++] = nums1[i++];
        while(j < nums2.length) result[t++] = nums2[j++];
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxNumber3(new int[]{2,5,6,4,4,0}, new int[]{7,3,8,0,6,5,7,6,2}, 15)));
    }
}
