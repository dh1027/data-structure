package com.heyuanjun.dataStructure;

import com.heyuanjun.dataStructure.stack.ArrayStack;

/**
 * Created by deng on 2020/3/22.
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.testBrackets("()[{}]"));
        System.out.println(t.testBrackets("((}}"));
    }

    /*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。*/
    private boolean testBrackets(String args) {
        ArrayStack<Character> arrayStack = new ArrayStack<>();
        for (int i = 0; i < args.length(); i++) {
            char c = args.charAt(i);
            if ('(' == c || '[' == c || '{' == c) {
                arrayStack.push(c);
            } else {
                if (arrayStack.isEmpty()) {
                    return false;
                }
                char topChar = arrayStack.pop();
                if (')' == c && topChar != '(') {
                    return false;
                }
                if ('}' == c && topChar != '{') {
                    return false;
                }
                if (']' == c && topChar != '[') {
                    return false;
                }
            }
        }
        return arrayStack.isEmpty();
    }
}
