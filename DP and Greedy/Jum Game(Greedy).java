class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int farest = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i <= farest && nums[i] + i > farest) {
                farest = nums[i] + i;
            }
        }
        return farest >= nums.length - 1;
    }
}
