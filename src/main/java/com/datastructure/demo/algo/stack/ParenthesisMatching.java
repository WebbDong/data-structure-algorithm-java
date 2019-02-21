package com.datastructure.demo.algo.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 栈在括号匹配中的应用
 * 假设表达式中只包含三种括号，()、[]、{}，并且他们可以任意嵌套{[{}]}或 [{()}([])] 等都为合法格式，
 * 而{[}()] 或 [({)] 为不合法的格式
 *
 * 思路:
 *      用栈来保存未匹配的左括号，从左到右依次扫描字符串。当扫描到左括号时，则将其压入栈中；当扫描到右括号时，从栈顶
 *      取出一个左括号。如果能匹配，则继续扫描剩下的字符串，如果扫描的过程中，遇到不能配对的右括号，或者栈中没有数据，则格式非法。
 * @Author: Webb Dong
 * @CreateDate: 2019/02/21 18:34
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/02/21 18:34
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class ParenthesisMatching {

    private static final Map<Character, Character> PARENTHESIS_MATCH_MAP;

    static {
        PARENTHESIS_MATCH_MAP = new HashMap<>(3);
        PARENTHESIS_MATCH_MAP.put('(', ')');
        PARENTHESIS_MATCH_MAP.put('[', ']');
        PARENTHESIS_MATCH_MAP.put('{', '}');
    }

    private ArrayDilatationStack<Character> stack;

    public ParenthesisMatching() {
        stack = new ArrayDilatationStack<>(5);
    }

    /**
     * 匹配校验，匹配返回true
     * @param value
     * @return
     */
    public boolean match(String value) {
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (isLeftParenthesis(c)) {
                // 左括号直接压入栈
                stack.push(c);
            } else if (isRightParenthesis(c)) {
                // 右括号，从栈顶取出一个左括号进行匹配
                Character left = stack.pop();
                if (left == null || !isMatch(left, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isMatch(Character left, Character right) {
        Character c = PARENTHESIS_MATCH_MAP.get(left);
        if (c == null) {
            return false;
        }
        return c.equals(right);
    }

    /**
     * 是否是左括号
     * @param c
     * @return
     */
    private boolean isLeftParenthesis(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    /**
     * 是否是右括号
     * @param c
     * @return
     */
    private boolean isRightParenthesis(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public static void main(String[] args) {
        ParenthesisMatching m = new ParenthesisMatching();
        System.out.println(m.match("{[{}]}"));
        System.out.println(m.match("[{()}([])]"));
        System.out.println(m.match("[{a()bcd}(g[ef]h)i]"));
        System.out.println(m.match("{[}()]"));
        System.out.println(m.match("[({)]"));
    }

}
