package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName BaseStation
 * @Date 2019/11/23 20:22
 * @Version 1.0
 */


class Coordinate {
    double x;
    double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

}

public class BaseStation {
    public static int baseStation(Coordinate[] nums, double radius) {
        int number = 0;

//        Arrays.sort(nums, new Comparator<Coordinate>() {
//            @Override
//            public int compare(Coordinate o1, Coordinate o2) {
//                return (int)(o1.x-o2.x);
//            }
//        });
        print(nums);
        //先纵坐标排序，绝对值排序，大的在前小的在后
        Arrays.sort(nums, ((o1, o2) -> (int) (Math.abs(o2.y) - Math.abs(o1.y))));
        //在横坐标排序，从小到大
        Arrays.sort(nums, (o1, o2) -> (int) (o1.x - o2.x));
        print(nums);

        System.out.println("基站的坐标点为：");
        int index = 0;
        while (index < nums.length) {
            double x = Math.sqrt(radius * radius - nums[index].y * nums[index].y) + nums[index].x;
            System.out.print(String.format("(%5.2f,%3d)  ", x, 0));
            index++;
            number++;
            while (true) {
                if (index < nums.length && (nums[index].x - x) * (nums[index].x - x) + nums[index].y * nums[index].y <= radius * radius) {
                    index++;
                } else {
                    break;
                }
            }
        }
        return number;
    }


    public static void print(Coordinate[] nums) {
        System.out.println("===============各点坐标为：==================");
        for (int i = 0; i < nums.length; i++)
            System.out.println("(" + nums[i].x + "," + nums[i].y + ")");
        System.out.println("============================================");
    }


    public static void main(String[] args) {
        Coordinate[] nums = new Coordinate[9];
        nums[0] = new Coordinate(-1, 1);
        nums[1] = new Coordinate(-3, 2);
        nums[2] = new Coordinate(4, -2);
        nums[3] = new Coordinate(1, -1);
        nums[4] = new Coordinate(5, 0);
        nums[5] = new Coordinate(3, 3);
        nums[6] = new Coordinate(6, 2);
        nums[7] = new Coordinate(4, 1);
        nums[8] = new Coordinate(1, 3);
        baseStation(nums, 4);
    }
}
