package Hulu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hulu_exam_3 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        // 主要逻辑 + 输出返回
        System.out.println(new Hulu_exam_3().solve(n, m, k, list));
        // 关闭输入
        sc.close();
    }

    // 处理逻辑 + 构造输出
    public int solve(int n, int m, int k, List<Integer> list) {
        int max = 0;
        for (int begin = 0; begin < n; begin++) {
            int count = 0;
            for (int end = begin; end < n && count <= m; end++) {
                if (list.get(end) < 0) {
                    count++;
                    if (count > m) {
                        break;
                    }
                }
                int cur = list.get(end) + list.get(begin);
                if (cur < k && cur > max) {
                    max = cur;
                }
            }
        }
        return max;
    }
}
