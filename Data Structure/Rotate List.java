/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        k = k % getSize(head);
        if(k == 0) return head;
        if(head.next == null) return head;
        ListNode n1 = head;     //find the n-th
        ListNode n2 = head;     //find the en
        for(int i = 0; i < k - 1; i++) {
            if(n2.next == null) return head;
            n2 = n2.next;
        }
        if(n2.next == null) return head;
        while(n2.next.next != null) {
            n2 = n2.next;
            n1 = n1.next;
        }
        if(n1 == n2) {
            ListNode temp = n1.next;
            n1.next = null;
            temp.next = head;
            head = temp;
            return head;
        }
        ListNode temp = n1.next;
        n1.next = null;
        n2.next.next = head;
        head = temp;
        return head;
    }

    public int getSize(ListNode head) {
        int count = 0;
        while(head.next != null) {
            count++;
            head = head.next;
        }
        count++;
        return count;
    }
}
