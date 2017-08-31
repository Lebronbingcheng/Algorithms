public class Solution {
    /*
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] nums, int target, int k) {
        // write your code here
        int[] result = new int[k];
        if (nums == null || nums.length == 0 || nums.length < k || k == 0) {
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
        int left = 0;
        int right = 0;
        if (Math.abs(target - nums[end]) < Math.abs(target - nums[start])) {
            left = end;
            right = end;
        } else {
            left = start;
            right = start;
        }
        result[0] = nums[left];
        left--;
        right++;
        int index = 1;
        while (left >= 0 && right < nums.length && index < k) {
            if (Math.abs(nums[left] - target) <= Math.abs(nums[right] - target)) {
                result[index] = nums[left];
                left--;
            } else {
                result[index] = nums[right];
                right++;
            }
            index++;
        }
        if (index < k) {
            if (left >= 0) {
                while(index < k) {
                    result[index] = nums[left];
                    left--;
                    index++;
                }
            } else {
                while(index < k) {
                    result[index] = nums[right];
                    right++;
                    index++;
                }
            }
        }
        return result;
    }
}
