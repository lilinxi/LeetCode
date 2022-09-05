package 阿里;

import java.util.Scanner;

public class template {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 主要逻辑 + 输出返回
        System.out.println(new template().solve(n, m));
        // 关闭输入
        sc.close();
    }

    // 处理逻辑 + 构造输出
    public String solve(int n, int m) {
        StringBuilder buf = new StringBuilder();
//        TODO
        buf.append(n);
        buf.append(m);
        buf.append(String.format("%.2f", n));
        return buf.toString();
    }
}
