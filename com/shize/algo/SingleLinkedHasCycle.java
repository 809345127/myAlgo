package com.shize.algo;

/**
 * 判断单链表是否有环
 */
public class SingleLinkedHasCycle {
    public boolean hasCycle(SNode head) {
        // 最少元素的边界情况，直接可以判断出来
        if (head == null || head.getNext() == null) {
            return false;
        }

        SNode slow = head;
        // 注意刚开始就不一样
        SNode fast = head.getNext();

        // 不相等就一直循环
        while (slow != fast) {
            // 快指针空，或者快指针下一位为空，到头，停止循环
            if (fast == null || fast.getNext() == null) {
                return false;
            }
            // 走
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return true;
    }
}
