class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        if (nums == null || nums.length  == 0) {
            results.add(subset);
            return results;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(nums, results, subset, used);
        return results;
    }

    private void helper(int[] nums, List<List<Integer>> results, List<Integer> subset, boolean[] used) {
        if (subset.size() == nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i - 1 >= 0 && used[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            used[i] = true;
            subset.add(nums[i]);
            helper(nums, results, subset, used);
            subset.remove(subset.size() - 1);
            used[i] = false;
        }
    }
}
