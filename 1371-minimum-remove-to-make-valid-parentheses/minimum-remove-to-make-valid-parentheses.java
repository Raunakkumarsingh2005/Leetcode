// Minimum Remove to Make Valid Parentheses
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) stack.pop();
                else sb.setCharAt(i, '#');
            }
        }

        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '#');
        }

        StringBuilder res = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            if (c != '#') res.append(c);
        }

        return res.toString();
    }
}