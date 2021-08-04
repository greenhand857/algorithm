package LeetCodeHot100;

import util.ListNode;

public class _019_RemoveNthFromEnd {
    // 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while(n>0 && fast != null){
            fast = fast.next;
            n--;
        }
        if(n != 0) throw new RuntimeException("Error!");

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
