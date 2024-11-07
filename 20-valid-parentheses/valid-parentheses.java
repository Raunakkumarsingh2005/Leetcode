class Solution {
    public boolean isValid(String s) {
        char[] a = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char i : a){
            if (i == ')' && !stack.isEmpty()) {
                if (stack.pop() =='('){
                    continue;
                }
                return false;
            }

            if (i == '}' && !stack.isEmpty()) {
                if (stack.pop() =='{'){
                    continue;
                }
                return false;
            }
            
            if (i == ']' && !stack.isEmpty()) {
                if (stack.pop() =='['){
                    continue;
                }
                return false;
            }

            else stack.push(i);
        }

        return stack.isEmpty();
    }
}