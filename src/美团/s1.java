package 美团;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 6 5
 5 6 7 8 9 10
 */
public class s1 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        int time = sc.nextInt();
        ArrayList<Integer> orderList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            orderList.add(sc.nextInt());
        }
        // 主要逻辑 + 输出返回
        System.out.println(new s1().solve(n, time, orderList));
        // 关闭输入
        sc.close();
    }

    // 处理逻辑 + 构造输出
    public int solve(int n, int time, ArrayList<Integer> orderList) {
        Collections.sort(orderList);
//        time ~ i*time
        int i = 1;
        for (int order : orderList) {
            if (order >= time * i) {
                i++;
            }
        }
        return n - i + 1;
    }
}
