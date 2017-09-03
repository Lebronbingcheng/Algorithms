class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int left = j + 1;
                int right = len - 1;
                int temp_target = target - nums[i] - nums[j];
                while (left < right) {
                    if (nums[left] + nums[right] == temp_target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        results.add(list);
                        left++;
                        while (nums[left] == nums[left - 1] && left < len - 1) {
                            left++;
                        }
                        right--;
                        while (nums[right] == nums[right + 1] && right > j) {
                            right--;
                        }

                    } else if (nums[left] + nums[right] < temp_target) {
                        left++;
                    } else {
                        right--;
                    }
                }
                while (j + 1< len - 2 && nums[j + 1] == nums[j]) {
                    j++;
                }
            }
            while (i + 1< len - 3 && nums[i + 1] == nums[i]) {
                    i++;
            }
        }
        return results;
    }
}
