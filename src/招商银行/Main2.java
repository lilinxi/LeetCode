package 招商银行;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x.add(sc.nextInt() + 1);
            y.add(sc.nextInt() + 1);
        }
        // 主要逻辑 + 输出返回
        List<Integer> ret = new Main2().solve(n, x, y);
        for (int i = 0; i < n; i++) {
            System.out.println(ret.get(i));
        }
        // 关闭输入
        sc.close();
    }


    // 处理逻辑 + 构造输出
    public List<Integer> solve(int n, List<Integer> x, List<Integer> y) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> xTmp = new ArrayList<>(x.subList(0, i));
            List<Integer> yTmp = new ArrayList<>(y.subList(0, i));
            ret.add(solveOne(xTmp, yTmp));
        }
        return ret;
    }

    public boolean[][] MAP;

    // 处理逻辑 + 构造输出
    public int solveOne(List<Integer> x, List<Integer> y) {
        MAP = new boolean[1002][1002];
        for (int i = 0; i < x.size(); i++) {
            MAP[x.get(i)][y.get(i)] = true;
        }
        boolean b;
        int count = 0;
        do {
            b = false;
            int n = x.size();
            for (int i = 0; i < n; i++) {
                if (judge(x.get(i), y.get(i))) {
                    b = true;
                    int tmp = fill(x.get(i), y.get(i), x, y);
                    count += tmp;
                }
            }
        } while (b);
        return count;
    }

    public boolean judge(int x, int y) {
        int count = 0;
        if (x > 0 && MAP[x - 1][y]) count++;
        if (x < 1001 && MAP[x + 1][y]) count++;
        if (y < 1001 && MAP[x][y + 1]) count++;
        if (y > 0 && MAP[x][y - 1]) count++;
        return count == 3;
    }

    public int fill(int x, int y, List<Integer> X, List<Integer> Y) {
        if (x > 0 && !MAP[x - 1][y]) {
            MAP[x - 1][y] = true;
            X.add(x - 1);
            Y.add(y);
            return 1;
        }
        if (x < 1001 && !MAP[x + 1][y]) {
            MAP[x + 1][y] = true;
            X.add(x + 1);
            Y.add(y);
            return 1;
        }
        if (y < 1001 && !MAP[x][y + 1]) {
            MAP[x][y + 1] = true;
            X.add(x);
            Y.add(y + 1);
            return 1;
        }
        if (y > 0 && !MAP[x][y - 1]) {
            MAP[x][y - 1] = true;
            X.add(x);
            Y.add(y - 1);
            return 1;
        }
        return 0;
    }

}
