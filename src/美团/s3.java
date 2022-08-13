package 美团;

import java.util.*;

/**
 * 4
 * 1 2 3 4
 * <p>
 * 2
 * 2 1
 */
public class s3 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        // 解析输入
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        // 主要逻辑 + 输出返回
        ArrayDeque<Integer> queue = new s3().solve(n, arr);
        while (!queue.isEmpty()) {
            System.out.print(queue.removeLast());
            System.out.print(" ");
        }
        // 关闭输入
        sc.close();
    }

    // 处理逻辑 + 构造输出
    public ArrayDeque<Integer> solve(int n, ArrayList<Integer> arr) {
        Collections.reverse(arr);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int a : arr) {
            queue.addLast(a);
//            System.out.println(queue);
            int e = queue.removeFirst();
//            System.out.println(queue);
            queue.addLast(e);
//            System.out.println(queue);
            e = queue.removeFirst();
//            System.out.println(queue);
            queue.addLast(e);
//            System.out.println(queue);
        }
//        System.out.println(queue);
        return queue;
    }
}
