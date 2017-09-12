public class Solution {
    /*
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (k > nums.length) {
            return new int[0];
        }

        int len = nums.length;
        int[] result = new int[len - k + 1];
        for (int i = 0; i <= len - k; i++) {
            int sum = 0;
            int index = i;
            for (int j = 0; j < k; j++) {
                sum += nums[index++];
            }
            result[i] = sum;
        }
        return result;
    }
}
