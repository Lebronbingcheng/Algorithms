class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] nums) {
        // write your code here
        int start = 1;
        int end = nums.length - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid - 1] > nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return start;
        }
        return end;
    }
}
