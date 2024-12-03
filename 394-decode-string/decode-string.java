class Solution {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuffer ts = new StringBuffer();
        int currentNum = 0;  // Variable to track the current number

        for (char a : s.toCharArray()) {
            if (Character.isDigit(a)) {
                // Build the number
                currentNum = currentNum * 10 + (a - '0');
            } 
            else if (a == '[') {
                // Push the current number and string to their respective stacks
                numberStack.push(currentNum);
                stringStack.push(ts.toString());
                currentNum = 0; // Reset currentNum for the next number
                ts = new StringBuffer(); // Reset ts for the next string
            } 
            else if (a == ']') {
                // Pop and decode
                StringBuffer temp = new StringBuffer(stringStack.pop());
                int repeatCount = numberStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    temp.append(ts);
                }
                ts = temp; // Update ts with the decoded string
            } 
            else {
                ts.append(a); // Build the current string
            }
        }

        return ts.toString();
    }
}
