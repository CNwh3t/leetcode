package simple.d20201116;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wh
 * @version 1.0
 * @date 2020/11/16 9:36
 */
public class TheSumOfTwoNumbers0001 {

    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    //示例:
    //给定 nums = [2, 7, 11, 15], target = 9
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/two-sum
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int[] twoSumX1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], Math.min(map.get(nums[i]), i));
            }else {
                map.put(nums[i], i);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            int i = target - (Integer) entry.getKey();
            if (map.containsKey(i)) {
                result = new int[]{(Integer) entry.getValue(), map.get(i)};
                return result;
            }
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[1] = i;
                result[0] = map.get(nums[i]);
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    public static int[] twoSumOffical(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];

        /*作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,8,6,9};
        // 8,0  7,1  4,2  1,3
        int[] ints = twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }
}
