class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node dummyHead = new Node();
    Node dummyTail = new Node();


    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            //detach the node
            removeNode(node);

            //connect the node to the tail
            addToBack(node);
            return node.val;
        }    
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToBack(node);

        } else if (map.size() < capacity) {
            Node node = new Node(key,value);
            addToBack(node);
            map.put(key,node);
        } else {
            Node leastRecent = dummyHead.next;
            removeNode(leastRecent);
            map.remove(leastRecent.key);

            Node node = new Node(key,value);
            addToBack(node);
            map.put(key,node);
        }

    }


    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToBack(Node node) {
        Node last = dummyTail.prev;

        last.next = node;
        node.prev = last;
        dummyTail.prev = node;
        node.next = dummyTail;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node() {}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
