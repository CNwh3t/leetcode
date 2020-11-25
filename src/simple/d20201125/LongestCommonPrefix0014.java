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
