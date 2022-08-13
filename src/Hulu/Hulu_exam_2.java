package Hulu;

import java.util.Scanner;

public class Hulu_exam_2 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int M = sc.nextInt();
        int N = sc.nextInt();
        String[] Map = new String[M];
        for (int j = 0; j < M; j++) {
            Map[j] = sc.next();
        }
        int A = sc.nextInt();
        int B = sc.nextInt();
        String[] pattern = new String[A];
        for (int j = 0; j < A; j++) {
            pattern[j] = sc.next();
        }
        // 主要逻辑 + 输出返回
        System.out.println(new Hulu_exam_2().solve(M, N, Map, A, B, pattern));
        // 关闭输入
        sc.close();
    }

    // 处理逻辑 + 构造输出
    public int solve(int M, int N, String[] Map, int A, int B, String[] pattern) {
        int count = 0;
        for (int i = 0; i <= M - A; i++) {
            for (int j = 0; j <= N - B; j++) {
                boolean valid = true;
                for (int k = 0; k < A; k++) {
                    for (int l = 0; l < B; l++) {
                        if (Map[k + i].charAt(l + j) != pattern[k].charAt(l)) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) {
                        break;
                    }
                }
                if (valid) {
                    count++;
                }
            }
        }
        return count;
    }
}
