/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode newHead = new ListNode(0);
        ListNode pointer = newHead;
        while (slow != null) {
            while (fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            if (slow.next == null) {
                pointer.next = slow;
            }
            if (fast == null) {
                break;
            }
            if (fast == slow.next) {
                slow.next = null;
                pointer.next = slow;
                pointer = pointer.next;
            }
            slow = fast;
            fast = slow.next;
        }
        return newHead.next;
    }
}
