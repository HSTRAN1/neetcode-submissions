class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int result = 0;

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int top = stack.removeLast();
                int width = stack.isEmpty() ? i : i - stack.peekLast() - 1;
                int area = width * heights[top];
                result = Math.max(result, area);                
            }
            stack.addLast(i);
            
        }
        while (!stack.isEmpty()) {
            int top = stack.removeLast();

            int width = stack.isEmpty() ? len : len - stack.peekLast() - 1;

            int area = width * heights[top];
            result = Math.max(result, area); 
        }

        return result;
    }
}
