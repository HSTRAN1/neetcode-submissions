class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            Comparator.comparingLong(
                (int[] p) -> (long) p[0] * p[0] + (long) p[1] * p[1]).reversed()
        );

        for (int[] point : points)
        {
            heap.offer(point);
            if (heap.size() > k)
                heap.poll();
        }

        int[][] result = new int[k][];
        int i = 0;
        for (int[] point: heap) {
            result[i] = point;
            i++;
        }

        return result;
    }
}
