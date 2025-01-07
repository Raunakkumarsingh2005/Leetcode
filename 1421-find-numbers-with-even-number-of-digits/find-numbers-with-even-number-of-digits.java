class Solution {
    public int findNumbers(int[] nums) {
        int even = 0;

        //travesing inside the array
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int n = nums[i];

            //determining the length of nums[i]
            while (n > 0) {
                n = n / 10;
                count++;
            }
            
            if (count % 2 == 0) {
                even++;
            }
        }

        return even;
    }
}