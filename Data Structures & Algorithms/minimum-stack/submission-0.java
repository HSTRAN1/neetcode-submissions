class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.addLast(val);

        if (minStack.isEmpty() || val <= minStack.peekLast()) {
            minStack.addLast(val);
        }    
    }
    
    public void pop() {
        int removed = stack.removeLast();

        if (minStack.peekLast() == removed) {
            minStack.removeLast();
        }     
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() { 
        return minStack.peekLast();
    }
}
