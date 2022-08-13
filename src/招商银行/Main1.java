package 招商银行;

import java.util.*;

/**
 * 5
 * 1 2 3 4 5
 * 5 4 3 2 1
 */
public class Main1 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
            m.put(a.get(i), a.size() - 1);
        }
        for (int i = 0; i < n; i++) {
            b.add(sc.nextInt());
        }
        // 主要逻辑 + 输出返回
        System.out.println(new Main1().solve(n, a, b, m));
        // 关闭输入
        sc.close();
    }


    // 处理逻辑 + 构造输出
    public int solve(int n, List<Integer> a, List<Integer> b, Map<Integer, Integer> m) {
        if (n <= 1) return 0;
        int point = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (point < n && a.get(point) == -1) point++;
            if (a.get(point) != b.get(i)) {
                ans++;
                int index = m.get(b.get(i));
                a.set(index, -1);
            } else {
                point++;
            }
        }
        return ans;
    }
}
