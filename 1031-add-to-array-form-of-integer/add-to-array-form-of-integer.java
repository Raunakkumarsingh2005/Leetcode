class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
    List<Integer> arr = new ArrayList<>();
    int carry = 0;
    int i = num.length - 1;

    // Process the digits of `num` and `k`
    while (i >= 0 || k > 0 || carry > 0) {
        int digit = (i >= 0 ? num[i] : 0); // Get the digit from `num` or 0 if `i` is out of bounds
        int sum = digit + (k % 10) + carry;

        carry = sum / 10; // Calculate carry
        arr.add(sum % 10); // Add the least significant digit to the result

        k /= 10; // Move to the next digit of `k`
        i--; // Move to the next digit of `num`
    }

    // Reverse the result to get the correct order
    Collections.reverse(arr);
    return arr;
}

}