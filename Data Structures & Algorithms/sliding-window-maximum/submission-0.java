class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer> deque = new ArrayDeque<>();
       int[] result = new int[nums.length - k + 1];
       int i = 0;

       for (int right = 0; right < nums.length; right++)
       {
            while (!deque.isEmpty() && deque.peekFirst() < right - k + 1) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]){
                deque.removeLast();
            }

            deque.addLast(right);   
            
            if (right >= k - 1){
                result[i] = nums[deque.peekFirst()];
                i++;
            }

            
       }
       return result;
    }
}
