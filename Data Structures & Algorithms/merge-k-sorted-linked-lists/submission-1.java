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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        PriorityQueue<ListNode> minHeap 
        = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null)
                continue;
            minHeap.add(lists[i]);
        }
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            if (min.next != null) 
                minHeap.add(min.next);
            tail.next = min;
            tail = tail.next;
        }
        return dummy.next;


    }
}
