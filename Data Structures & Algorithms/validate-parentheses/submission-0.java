class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char bracket: s.toCharArray()) {
            if (bracket == '(')
                stack.addLast(')');
            else if(bracket == '{')
                stack.addLast('}');
            else if (bracket == '[')
                stack.addLast(']');
            else
            {
                if (stack.isEmpty() || stack.removeLast() != bracket)
                    return false;
            }

        }
        return stack.isEmpty();
    }
}
