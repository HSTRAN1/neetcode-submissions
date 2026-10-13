class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++)
        {
            int num1, num2;

            if (tokens[i].equals("+")) {
                num2 = stack.removeLast();
                num1 = stack.removeLast();
                stack.addLast(num1 + num2);

            } else if (tokens[i].equals("-")) {
                num2 = stack.removeLast();
                num1 = stack.removeLast();
                stack.addLast(num1 - num2);

            } else if (tokens[i].equals("*")) {
                num2 = stack.removeLast();
                num1 = stack.removeLast();
                stack.addLast(num1 * num2);

            } else if (tokens[i].equals("/")) {
                num2 = stack.removeLast();
                num1 = stack.removeLast();
                stack.addLast(num1 / num2);

            } else {
                stack.addLast(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peekLast();
    }
}
