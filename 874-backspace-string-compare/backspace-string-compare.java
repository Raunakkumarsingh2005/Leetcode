class Solution {
    public boolean backspaceCompare(String s, String t) {
        String str1, str2;
        Stack<Character> stk = new Stack<>();
        for (Character i : s.toCharArray()) {
            if (i.equals('#') && !stk.empty()) {
                stk.pop();
            } else if (!i.equals('#')){
                stk.push(i);
            }
        }
        str1 = stk.toString();
        stk.clear();

        for (Character i : t.toCharArray()) {
            if (i.equals('#') && !stk.empty()) {
                stk.pop();
            } else if (!i.equals('#')){
                stk.push(i);
            }
        }
        str2 = stk.toString();

        return str1.equals(str2) ? true : false ;

    }
}