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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode groupPrev = dummy;
        dummy.next = head;
        ListNode temp = groupPrev;
        int link = 0;

        while (groupPrev.next != null) {
            while (temp.next != null && link < k) {
                temp = temp.next;
                link++;
            }
            if (link < k) 
                break;
            ListNode groupNext = temp.next;

            ListNode prev = groupNext;
            ListNode cur = groupPrev.next;
            ListNode original = groupPrev.next;

            while (cur != groupNext) {
                ListNode next = cur.next;

                cur.next = prev;
                prev = cur;
                cur = next;
            }
            
            groupPrev.next = prev;
            groupPrev = original;

            temp = groupPrev;
            link = 0;
        }
        

        return dummy.next;
    
    }
}
