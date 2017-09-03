/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Comparator<ListNode> Increase = new Comparator<ListNode>() {
            public int compare (ListNode a, ListNode b) {
                if (a.val < b.val) {
                    return -1;
                }  else if (a.val > b.val) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, Increase);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            pointer.next = node;
            pointer = pointer.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return head.next;
    }
}
