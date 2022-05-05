package Tencent可持续发展;

import java.util.*;

public class main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(-1);
        arr.add(2);
        arr.add(-2);
        arr.add(0);
        arr.add(3);
        arr.add(0);
        print(arr);
        moveZeroLeftV3(arr);
        print(arr);
    }

    public static void print(List<Integer> arr) {
        for (Integer a : arr) {
            System.out.print(a);
            System.out.print(" ");
        }
        System.out.println();
    }

    // 非零元素移到左边
    public static void moveZeroLeft(List<Integer> arr) {
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == 0) {
                    return 1;
                } else if (o2 == 0) {
                    return -1;
                }
                return 0;
            }
        });
    }

    // 非零元素移到左边
    public static List<Integer> moveZeroLeftV2(List<Integer> arr) {
        int nonZeroIndex = 0;
        int zeroIndex = arr.size() - 1;
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            ret.add(-100);
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                ret.set(zeroIndex, 0);
                zeroIndex--;
            } else {
                ret.set(nonZeroIndex, arr.get(i));
                nonZeroIndex++;
            }
        }
        return ret;
    }

    public static void swap(List<Integer> arr, int index1, int index2) {
        int value1 = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, value1);
    }

    // 非零元素移到左边
    public static void moveZeroLeftV3(List<Integer> arr) {
        int zeroIndex = arr.size() - 1;
        for (int i = 0; i <= zeroIndex; ) {
            if (arr.get(i) == 0) {
                swap(arr, i, zeroIndex);
                zeroIndex--;
            } else {
                i++;
            }
        }
    }

}
