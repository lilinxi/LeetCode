package Hulu;

import java.util.Arrays;
import java.util.Scanner;

public class Hulu_exam_1 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        // 主要逻辑 + 输出返回
        System.out.println(new Hulu_exam_1().solve(n, list));
        // 关闭输入
        sc.close();
    }

    // 处理逻辑 + 构造输出
    public int solve(int n, int[] list) {
        int depth = (int) (Math.log(n + 1) / Math.log(2));
        int num = depth * 2;
        int lastLayer[] = Arrays.copyOfRange(list, num, list.length);
        int count = 0;
        for (int i = 0; i < lastLayer.length; i++) {
            if (lastLayer[i] != -1) {
                count++;
            }
        }
        return count;
    }
}
