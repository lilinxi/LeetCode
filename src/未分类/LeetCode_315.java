package 未分类;

import java.util.*;

/**
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 示例 2：
 * <p>
 * 输入：nums = [-1]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode_315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            ret.add(0);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    ret.set(i, ret.get(i) + 1);
                }
            }
        }
        return ret;
    }

    public List<Integer> countSmaller_Less(int[] nums) {
        List<Integer> ret = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            ret.add(0);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i > -1; i--) {
            int v = nums[i];
            if (map.containsKey(v)) {
                int beforeIndex = map.get(v);
                int beforeValue = ret.get(beforeIndex);
                for (int j = i + 1; j < beforeIndex; j++) {
                    if (nums[j] < nums[i]) {
                        ret.set(i, ret.get(i) + 1);
                    }
                }
                ret.set(i, ret.get(i) + beforeValue);
                map.put(v, i);
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) {
                        ret.set(i, ret.get(i) + 1);
                    }
                }
                map.put(v, i);
            }
        }
        return ret;
    }

    public List<Integer> countSmaller_Sort(int[] nums) {
        List<Integer> ret = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            ret.add(0);
        }
        List<Integer> rightQueue = new LinkedList<>();
        for (int i = nums.length - 1; i > -1; i--) {
            int v = nums[i];
            ListIterator<Integer> it = rightQueue.listIterator();
            int j = 0;
            while (it.hasNext()) {
                if (it.next() >= v) {
                    break;
                }
                j++;
            }
            rightQueue.add(j, v);
            int a = rightQueue.indexOf(v);
            ret.set(i, a);
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        System.out.println(new LeetCode_315().countSmaller(nums));
        System.out.println(new LeetCode_315().countSmaller_Less(nums));
        System.out.println(new LeetCode_315().countSmaller_Sort(nums));
    }
}
