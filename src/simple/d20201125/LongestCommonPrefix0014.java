package simple.d20201125;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wh
 * @version 1.0
 * @date 2020/11/25 16:09
 */
public class LongestCommonPrefix0014 {
    //    编写一个函数来查找字符串数组中的最长公共前缀。
    //    如果不存在公共前缀，返回空字符串 ""。
    //    示例 1:
    //    输入: ["flower","flow","flight"]
    //    输出: "fl"
    //    示例 2:
    //    输入: ["dog","racecar","car"]
    //    输出: ""
    //    解释: 输入不存在公共前缀。
    //    说明:
    //    所有输入只包含小写字母 a-z 。
    //    来源：力扣（LeetCode）
    //    链接：https://leetcode-cn.com/problems/longest-common-prefix
    //    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static String longestCommonPrefix(String [] strs) {
        List<String> stringList = Arrays.asList(strs);
        if (stringList == null || stringList.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        f: for (int i = 0; i < stringList.get(0).length(); i++) {
            char charAtI = stringList.get(0).charAt(i);
            stringBuffer.append(charAtI);
            for (int j = 1; j < stringList.size(); j++) {
                if (stringList.get(j).length() < stringBuffer.length() || stringList.get(j).charAt(i) != charAtI) {
                    stringBuffer.replace(i, i+1, "");
                    break f;
                }
            }
        }
        return stringBuffer.toString();
    }

    public String longestCommonPrefixOfficial1(String[] strs) {
        // 横向扫描
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    // 横向扫描
    // 时间复杂度 O(mn), m是字符串数组中字符串的平均长度，n是字符串的数量。
    // 最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
    // 空间复杂度 O(1), 使用的额外空间复杂度为常数。

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    public String longestCommonPrefixOfficial2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 第一个字符串的长度
        int length = strs[0].length();
        // 字符串数组的长度
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // 纵向扫描
    // 时间复杂度 O(mn), m是字符串数组中字符串的平均长度，n是字符串的数量。
    // 最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
    // 空间复杂度 O(1), 使用的额外空间复杂度为常数。

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

    public String longestCommonPrefixOfficial3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    // 分治 TODO
    // 时间复杂度 O(mn), 其中m是字符串数组中字符串的平均长度，n是字符串的数量。
    // 时间复杂度的递推式是 T(n) = 2* T(n/2) + O(m)，通过计算可得 T(n) = O(mn)。
    // 空间复杂度 O(m log n),其中m是字符串数组中字符串的平均长度，n是字符串的数量。
    // 空间复杂度主要取决于递归调用的层数，层数最大为log n，每层需要m的空间存储返回结果。

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    public String longestCommonPrefixOfficial4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 二分查找 TODO
    // 时间复杂度 O(mn log n),其中m是字符串数组中字符串的平均长度，n是字符串的数量。
    // 二分查找的迭代执行次数是 O(log m)，每次迭代最多需要比较mn个字符。
    // 空间复杂度 O(1), 使用的额外空间复杂度为常数。

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/



    public static void main(String[] args) {
        // String[] strings = {"flower", "flow", "flight"};
//        String[] strings = {"dog","racecar","car"};
        String[] strings = {"ab","a"};
        System.out.println(longestCommonPrefix(strings));
    }

}
