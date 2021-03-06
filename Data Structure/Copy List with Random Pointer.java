/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode point = head;
        while (point != null) {
            map.put(point, new RandomListNode(point.label));
            point = point.next;
        }
        point = head;
        while (point != null) {
            RandomListNode pointer = map.get(point);
            pointer.next = map.get(point.next);
            pointer.random = map.get(point.random);
            point = point.next;
        }
        return map.get(head);
    }
}
