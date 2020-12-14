package com.mk.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头反过来打印出每个结点的值。
 * 2 -> 4 -> 5 -> 9
 *
 * @author mukong
 */
public class ReverseList {

    /**
     *
     * @param listNode
     * @return
     */
    public List<Integer> reverseListRecursion(ListNode listNode) {

        List<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(reverseListRecursion(listNode.getNext()));
            ret.add(listNode.getVal());
        }
        return ret;
    }

    /**
     * 栈实现
     * @param listNode
     * @return
     */
    public List<Integer> reverseListUseStack(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }

        Stack<Integer> stack = new Stack<>();
        while (listNode.getNext() != null) {
            stack.add(listNode.getVal());
            listNode = listNode.getNext();
        }

        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }

        return ret;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode listNode = new ListNode(2);
        System.out.println(reverseList.reverseListUseStack(listNode));
        reverseList.reverseListRecursion(listNode);
    }
}

class ListNode {
    private Integer val;
    private ListNode next;

    public ListNode(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}