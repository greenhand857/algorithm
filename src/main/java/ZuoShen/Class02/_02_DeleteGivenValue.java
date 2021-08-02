package ZuoShen.Class02;

import util.Node;

public class _02_DeleteGivenValue {
    // 删除链表中的指定元素（无序链表）
    // 算法思路，先while循环找到 head.val != num的节点
    // cur.val == num时就跳过 pre.next=cur.next
    // 不相等时，移动pre到下一节点
    public static Node removeValue(Node head,int num){
        while (head != null){
            if(head.val != num){
                break;
            }
            head = head.next;
        }
        // 循环跳出后 head来到第一个不需要删的位置
        Node pre = head;
        Node cur = head;
        while (cur != null){
            if(cur.val == num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
