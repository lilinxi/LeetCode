package 招商银行;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 5
 1 2 3 4 5
 5 4 3 2 1
 */
public class Main {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            b.add(sc.nextInt());
        }
        // 主要逻辑 + 输出返回
        System.out.println(new Main().solve(a, b));
        // 关闭输入
        sc.close();
    }

    public int count = 0;


    // 处理逻辑 + 构造输出
    public int solve(List<Integer> a, List<Integer> b) {
        if (a.isEmpty()) {
            return count;
        } else {
            if (a.get(0) == b.get(0)) {
                return solve(a.subList(1, a.size()), b.subList(1, b.size()));
            } else {
                a.remove(new Integer(b.get(0)));
                count++;
                return solve(a, b.subList(1, b.size()));
            }
        }
    }
}
