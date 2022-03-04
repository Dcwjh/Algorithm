import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName KQlist
 * @Date 2021/9/8 17:04
 * @Version 1.0
 */


public class KQlist {

    private ArrayList<Integer> initList;

    public KQlist(ArrayList<Integer> list) {
        this.initList = list;
    }

    private void print() {
        for (int i = 0; i < initList.size(); i++) {
            System.out.print(initList.get(i) + " ");
        }
        System.out.println();
    }

    public void init(int size) {
        initList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            initList.add((int) Math.random() * 500 + 10);
        }
    }

    public void listSet() {
        initList.stream().distinct();
    }

    public void sort() {
        Collections.sort(initList);
    }

    public int getRandom() {
        int size = initList.size();
        int index = (int) Math.random() * size;
        return initList.get(index);
    }

    public int find(int target) {
        int l = 0;
        int r = initList.size();
        while (l < r) {
            int m = l + r >> 1;
            if (initList.get(m) < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (initList.get(l) == target) return l;
        return -1;
    }

    public List<Integer> getSquare(int n) {
        final int size = initList.size();
        ArrayList<Integer> res = new ArrayList<>();
        ExecutorService threadPool =
            Executors.newFixedThreadPool(300);
        Semaphore semaphore = new Semaphore(n);
        for (int i = 0; i < size; i++) {
            int finalI = i;
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                    int ans = cal(initList.get(finalI));
                    res.add(ans);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        return res;
    }

    private int cal(int m) {
        return m * m;
    }


    public static void main(String[] args) {
        KQlist operator = new KQlist(new ArrayList<>());
        operator.init(10);
        operator.print();
        operator.listSet();
        operator.print();
        operator.sort();
        operator.print();
        System.out.println(operator.getRandom());
        System.out.println(operator.find(501));
    }

}

