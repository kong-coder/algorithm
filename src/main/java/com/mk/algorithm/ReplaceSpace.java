package com.mk.algorithm;

/**
 * 将一个字符串中的空格替换成 "%20"。
 * Input: "A B"
 * Output: "A%20B"
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/5.%20%E6%9B%BF%E6%8D%A2%E7%A9%BA%E6%A0%BC.md
 * @author mukong
 */
public class ReplaceSpace {

    public String replaceSpace(String str) {

        StringBuffer sb = new StringBuffer(str);
        int p1 = sb.length() - 1;
        for (int i = 0;  i <= p1; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }

        int p2 = sb.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = sb.charAt(p1--);
            if (c == ' ') {
                sb.setCharAt(p2--, '0');
                sb.setCharAt(p2--, '2');
                sb.setCharAt(p2--, '%');
            } else {
                sb.setCharAt(p2--, c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("a b   c"));
    }
}