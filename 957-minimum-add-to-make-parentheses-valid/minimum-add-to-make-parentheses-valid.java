class Solution {
    public int minAddToMakeValid(String s) {
       char[] arr = s.toCharArray();
       Stack<Character> stack = new Stack<>() ;

        for (char a : arr) {
            if (a == '(') {
                stack.push(a);
            }
            
            else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(a);
                }
            }
        }

        return stack.size();
    }
}