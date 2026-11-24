class KthLargest {
    int limit;
    PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        limit = k;
        heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > limit)
                heap.poll();
        }
    }
    
    public int add(int val) {
        heap.offer(val);

        if (heap.size() > limit) {
            heap.poll();
        }
        return heap.peek();
    }
}
