package Tencent;

import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int a = in.nextInt();
        System.out.println(new Main1().valid("()"));
        System.out.println(new Main1().valid("(*))"));
    }

    public boolean validOnly(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(1);
            } else if (c == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    public boolean valid(String str) {
        if (str.contains("*")) {
            boolean retLeft = valid(str.replaceFirst("\\*", "("));
            if (retLeft) {
                return true;
            }
            boolean retRight = valid(str.replaceFirst("\\*", ")"));
            if (retRight) {
                return true;
            }
        }
        return validOnly(str);
    }
}