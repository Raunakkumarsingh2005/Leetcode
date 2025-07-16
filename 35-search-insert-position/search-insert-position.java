class Solution {
    public int searchInsert(int[] nums, int target) {
       return binarysearch(nums , target) ;
    //    if (nums[a] == target){
    //     return a ;                 [don't use this approach to understand first 
    //                                   dry run binary search code]
    //    }
    //    else if (nums[a] > target){
    //     return a - 1 ;
    //    }
    //    return a + 1 ;
    }
    int binarysearch(int[] arr, int target){
        int start = 0 ;
        int end = arr.length - 1 ;
        while (start <= end){
            int mid = start + (end - start) / 2 ;
            if (arr[mid] > target){
                end = mid - 1 ;
            } 
            else if(arr[mid] < target){
                start = mid + 1 ;
            } 
            else{
                return mid ;
            }
        } 
        return start ;
    }
}