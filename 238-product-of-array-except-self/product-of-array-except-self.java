class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Step 1: Calculate Left Products
        // ans[i] will contain the product of all elements to the left of i
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate Right Products on the fly
        // We use a variable 'right' to track the product of all elements to the right
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            // Multiply the existing left product by the current right product
            ans[i] = ans[i] * right;
            // Update the right product for the next element to the left
            right = right * nums[i];
        }

        return ans;
    }
}