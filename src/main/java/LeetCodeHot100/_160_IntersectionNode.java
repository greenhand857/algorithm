package LeetCodeHot100;

import util.ListNode;

public class _160_IntersectionNode {
    // 求两链表的相交节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode x = headA;
        ListNode y = headB;
        while( x != y){
            x = x!=null ? x.next : headB;
            y = y!=null ? y.next : headA;
        }
        return x;
    }
}
