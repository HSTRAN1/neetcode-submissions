/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node traverse1 = head;
        Node traverse2 = head;

        while (traverse1 != null){
            map.put(traverse1, new Node(traverse1.val));
            traverse1 = traverse1.next;
        }

        while (traverse2 != null){
            Node copiedNode = map.get(traverse2);

            copiedNode.next = map.get(traverse2.next);
            copiedNode.random = map.get(traverse2.random);

            traverse2 = traverse2.next;
        }

        return map.get(head);

    }
}
