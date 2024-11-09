class Solution {
    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                continue;
            }
            stack.pop();

            // else if (stack.peek() == c) {
            //     stack.pop();
            // }
        }

        StringBuilder op = new StringBuilder();
        while (!stack.isEmpty()) {
            op.append(stack.pop());
        }

        op = op.reverse();
        return op.toString();
    }
}