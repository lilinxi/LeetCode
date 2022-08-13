package 美团;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 3
 * 5 7 8
 */
public class s5 {
    public static ArrayList<Integer> orderList;

    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        orderList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            orderList.add(sc.nextInt());
        }

        // 主要逻辑 + 输出返回
        System.out.println(getMax(0));
        // 关闭输入
        sc.close();
    }


    public static int getMax(int i) {
        int maxLeft = 0;
        int maxRight = 0;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < orderList.size()) {
            maxLeft = getMax(left);
        }
        if (right < orderList.size()) {
            maxRight = getMax(right);
        }
        return orderList.get(i) + Math.max(maxLeft, maxRight);
    }
}
