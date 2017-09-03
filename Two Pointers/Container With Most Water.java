class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left <= right) {
            result = Math.max(result, computeArea(left, right, height));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    private int computeArea(int left, int right, int[] height) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}
