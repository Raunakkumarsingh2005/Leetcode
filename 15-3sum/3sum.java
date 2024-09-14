import java.util.Arrays ;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums); // Sort the array
    List<List<Integer>> main = new ArrayList<>(); // Result list
    
    for (int i = 0; i < nums.length - 2; i++) {
        // Skip duplicates for the first element
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        
        int j = i + 1;
        int k = nums.length - 1;
        
        while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            
            if (sum == 0) {
                // Found a triplet
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[k]);
                main.add(list);
                
                // Skip duplicates for the second element
                while (j < k && nums[j] == nums[j + 1]) j++;
                // Skip duplicates for the third element
                while (j < k && nums[k] == nums[k - 1]) k--;
                
                // Move to the next possible pair
                j++;
                k--;
            } else if (sum > 0) {
                k--; // Decrease sum
            } else {
                j++; // Increase sum
            }
        }
    }
    
    return main;
    }
}
