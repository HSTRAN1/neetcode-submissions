class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for (int current = 0; current < n; current++)
        {
            while (!stack.isEmpty() && temperatures[current] > temperatures[stack.peekLast()])
            {
                int previous = stack.removeLast();
                result[previous] = current - previous;
            }
            stack.addLast(current);

        }
        return result;

    }
}
