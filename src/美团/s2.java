package 美团;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 2 2 5
 SDWAS

 2 2 5
 SWSWSW
 */
public class s2 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        sc.nextLine();
        String command = sc.nextLine();
        command = command.trim();
        // 主要逻辑 + 输出返回
        System.out.println(new s2().solve(n, m, command));
        // 关闭输入
        sc.close();
    }

    // 处理逻辑 + 构造输出
    public String solve(int n, int m, String command) {
        boolean[][] room = new boolean[n][m];
        room[0][0] = true;
        int x = 0;
        int y = 0;
        int all = 1;
        int steps = 0;
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'W') {
                steps++;
                y = y - 1;
                if (y >= 0 && y < m) {
                    if (!room[x][y]) {
                        all++;
                        if (all == n * m) {
                            buf.append("Yes");
                            buf.append("\n");
                            buf.append(steps);
                            return buf.toString();
                        }
                    }
                    room[x][y] = true;
                } else {
                    y = y + 1;
                }
            } else if (c == 'S') {
                steps++;
                y = y + 1;
                if (y >= 0 && y < m) {
                    if (!room[x][y]) {
                        all++;
                        if (all == n * m) {
                            buf.append("Yes");
                            buf.append("\n");
                            buf.append(steps);
                            return buf.toString();
                        }
                    }
                    room[x][y] = true;
                } else {
                    y = y - 1;
                }
            } else if (c == 'A') {
                steps++;
                x = x - 1;
                if (x >= 0 && x < n) {
                    if (!room[x][y]) {
                        all++;
                        if (all == n * m) {
                            buf.append("Yes");
                            buf.append("\n");
                            buf.append(steps);
                            return buf.toString();
                        }
                    }
                    room[x][y] = true;
                } else {
                    x = x + 1;
                }
            } else if (c == 'D') {
                steps++;
                x = x + 1;
                if (x >= 0 && x < n) {
                    if (!room[x][y]) {
                        all++;
                        if (all == n * m) {
                            buf.append("Yes");
                            buf.append("\n");
                            buf.append(steps);
                            return buf.toString();
                        }
                    }
                    room[x][y] = true;
                } else {
                    x = x - 1;
                }
            }
        }
        buf.append("No");
        buf.append("\n");
        buf.append(n *m- all);
        return buf.toString();
    }
}
