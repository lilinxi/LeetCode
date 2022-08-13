package 招商银行;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        int tX = sc.nextInt();
        int tY = sc.nextInt();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x.add(sc.nextInt());
            y.add(sc.nextInt());
        }
        // 主要逻辑 + 输出返回
        List<Integer> ret = new Main3().solve(n, tX, tY, x, y);
        for (int i = 0; i < n; i++) {
            System.out.println(ret.get(i));
        }
        // 关闭输入
        sc.close();
    }

//    public


    // 处理逻辑 + 构造输出
    public List<Integer> solve(int n, int tX, int tY, List<Integer> x, List<Integer> y) {
        return null;
    }
}
