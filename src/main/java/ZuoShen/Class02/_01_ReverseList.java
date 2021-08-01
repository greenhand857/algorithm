package ZuoShen.Class02;

import util.DoubleNode;
import util.Node;

public class _01_ReverseList {
    // 反转单链表
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;

        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 反转双向链表
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
