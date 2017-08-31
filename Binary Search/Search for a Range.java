public class Solution {
    /*
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] nums, int target) {
        // write your code here
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] != target && nums[end] != target) {
            return result;
        }
        int startIndex = 0;
        if (nums[start] == target) {
            startIndex = start;
        } else {
            startIndex = end;
        }
        result[0] = startIndex;
        int endIndex = nums.length - 1;
        while (startIndex + 1 < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (nums[mid] > target) {
                endIndex = mid;
            } else {
                startIndex = mid;
            }
        }
        if (nums[endIndex] == target) {
            result[1] = endIndex;
        } else {
            result[1] = startIndex;
        }
        return result;
    }
}
