class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);

            for (int j = nums2.length-1; j > -1; j--){
                if (nums2[j] == nums1[i]){
                    ans[i] = stack.peek();
                    break;
                }

                else if(nums2[j] > nums1[i]){
                    stack.push(nums2[j]);
                }
            }
        }

        return ans;
    }
}