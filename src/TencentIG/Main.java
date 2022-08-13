package TencentIG;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] area = new String[n];
        for (int i = 0; i < n; i++) {
            area[i] = sc.nextLine();
        }
        // 主要逻辑 + 输出返回
        System.out.println(new Main().solve(n, m, area));
        // 关闭输入
        sc.close();
    }

    public int getCount(String str, String c) {
        String[] split = str.split(c);
        return split.length - 1;
    }

    // 处理逻辑 + 构造输出
    public int solve(int n, int m, String[] area) {
        int ret = 0;
        int beforeCount = 0;
        int curCount = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            curCount = getCount(area[i], "1");
            if (curCount == 1 || curCount == 0) {
                continue;
            }
            if (curCount > beforeCount) {
                beforeCount = curCount;
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (area[i].toCharArray()[j] == '0' && flag) {
                    ret++;
                } else if (area[i].toCharArray()[j] == '1') {
                    flag = !flag;
                }
            }
            beforeCount = curCount;
        }
        return ret;
    }
}
