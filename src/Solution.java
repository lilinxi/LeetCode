import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串 
     * @return string字符串
     */
    public String reverseString (String str) {
        // write code here
        StringBuilder strBuilder = new StringBuilder(str);
        for (int i = 0; i < str.length() / 2; i++) {
            char c = str.charAt(i);
            strBuilder.setCharAt(i, str.charAt(str.length() - 1 - i));
            strBuilder.setCharAt(str.length() - 1 - i, c);
        }
        return strBuilder.toString();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param A int整型一维数组
     * @return int整型
     */
    public int removeDuplicates (int[] A) {
        // write code here
        if (A.length == 0) {
            return 0;
        }
        int cur = A[0];
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == cur) {
                continue;
            }else{
                cur = A[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseString("abcde"));
        System.out.println(new Solution().removeDuplicates(new int[]{1,1,2,2,3}));
    }



}