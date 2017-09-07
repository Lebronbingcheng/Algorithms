class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] res1 = new int[len]; //without the first house
        int[] res2 = new int[len]; //without the last house
        res2[0] = 0;
        res2[1] = nums[0];
        for (int i = 2; i < len; i++) {
            res2[i] = Math.max(res2[i - 1], res2[i - 2] + nums[i - 1]);
        }
        res1[0] = 0;
        res1[1] = nums[1];
        for (int i = 2; i < len; i++) {
            res1[i] = Math.max(res1[i - 1], res1[i - 2] + nums[i]);
        }
        return Math.max(res1[len - 1], res2[len - 1]);

    }
}
