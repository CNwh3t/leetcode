package simple.d20201126;

/**
 * @author wh
 * @version 1.0
 * @date 2020/11/26 11:38
 */
public class IsValid0020 {

    //    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //    有效字符串需满足：
    //    左括号必须用相同类型的右括号闭合。
    //    左括号必须以正确的顺序闭合。
    //    注意空字符串可被认为是有效字符串。
    //    示例 1:
    //    输入: "()"
    //    输出: true
    //    示例 2:
    //    输入: "()[]{}"
    //    输出: true
    //    示例 3:
    //    输入: "(]"
    //    输出: false
    //    示例 4:
    //    输入: "([)]"
    //    输出: false
    //    示例 5:
    //    输入: "{[]}"
    //    输出: true
    //    来源：力扣（LeetCode）
    //    链接：https://leetcode-cn.com/problems/valid-parentheses
    //    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static boolean isValid(String s) {
        if (s == null || s.trim().equals("")) {
            return true;
        }
        int lastMatch = s.length();
        for (int i = 0; i < s.length() && i < lastMatch; i++) {
            Character theOtherHalf = getTheOtherHalf(s.charAt(i));
            if (theOtherHalf == null) {
                return false;
            }
            int i1 = s.lastIndexOf(theOtherHalf);
            if (i1 == -1 || i1 <= i || i1 > lastMatch) {
                return false;
            }else {
                lastMatch = i1;
            }
        }
        return true;
    }

    private static Character getTheOtherHalf(Character character) {
        switch (character) {
            case '{' :
                return '}';
            case '(' :
                return ')';
            case '[' :
                return ']';
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));
    }

}
