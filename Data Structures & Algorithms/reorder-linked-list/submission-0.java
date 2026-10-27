/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode front = head;

        while (front.next != null && front.next.next != null) {
            ListNode previous = front;
            ListNode tail = front;

            while (tail.next != null)
            {
                previous = tail;
                tail = tail.next;
            }

            //cut off the tail
            previous.next = null;

            //add the tail to the front
            tail.next = front.next;
            front.next = tail;

            front = tail.next;
        }
    }
}
