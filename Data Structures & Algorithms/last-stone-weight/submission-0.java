class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int firstStone = maxHeap.poll();
            int secondStone = maxHeap.poll();
            int difference = firstStone - secondStone;

            if (difference != 0)
                maxHeap.offer(difference);
        }
        if (!maxHeap.isEmpty())
            return maxHeap.peek();

        return 0;
    }
}
