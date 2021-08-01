package LeetCodeHot100;

import util.Node;

/**
 2. 两数相加
 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 请你将两个数相加，并以相同形式返回一个表示和的链表
 */

class _02_AddTwoNum {
    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node cur = dummy;
        int carry = 0;

        while(l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x+y+carry;

            carry = sum/10;
            cur.next = new Node(sum%10);
            cur = cur.next;
            if(l1 != null) l1=l1.next;
            if(l2 != null) l2=l2.next;
        }
        if(carry != 0) cur.next=new Node(carry);
        return dummy.next;
    }
}
