import java.util.*;
import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ListOperator
 * @Date 2021/9/8 16:26
 * @Version 1.0
 */


public class ListOperator {

    private List<Integer> list;

    public ListOperator(int size) {
        list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * 11) + 500);  //random() 种子[0,1)
        }
    }

    void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }


    public void listSet() {
        Set<Integer> set = new HashSet<>(list);
        list = new ArrayList<>(set);
    }

    public void sort() {
        Collections.sort(list);
    }

    public int getRandom() {
        int size = list.size();
        int index = (int) Math.random() * size;
        return list.get(index);
    }

    public int find(int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            //int m = l + r >> 1;  //溢出风险
            int m = l + (r - l) >> 1;
            if (list.get(m) < target) {
                l = m + 1;
            } else if(list.get(m) > target){
                r = m;
            } else{
                return m;
            }
        }
        return -1;
    }

    public List<Integer> getSquare(final int nThreads) throws ExecutionException, InterruptedException {
        final int size = list.size();
        List<Integer> res = new ArrayList<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
        List<Future<List<Integer>>> futures = new ArrayList<>(nThreads);
        for (int i = 0; i < nThreads; i++) {
            final  List<Integer> sunList = list.subList(size / nThreads * i, size/nThreads *(i + 1));
            final int threadi = i;
            Callable<List<Integer>> task = new Callable<List<Integer>>() {
                @Override
                public List<Integer> call() throws Exception {
                    if(threadi == 2){
                        Thread.sleep(200);
                    }
                    List<Integer> temp = new ArrayList<>();
                    for(Integer num : sunList) {
                        temp.add(num * num);
                    }
                    return temp;
                }
            };
            futures.add(threadPool.submit(task));
        }
        for(Future<List<Integer>> future : futures){
            for(Integer t : future.get()){
                res.add(t);
            }
        }
        threadPool.shutdown();
        return res;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ListOperator operator = new ListOperator(10);
        operator.print();
//        operator.listSet();
//        operator.print();
//        operator.sort();
//        operator.print();
//        System.out.println(operator.getRandom());
//        System.out.println(operator.find(501));
        List<Integer> res = operator.getSquare(5);
        System.out.println(res);

    }


}

