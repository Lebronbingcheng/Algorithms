class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(subset);
            return results;
        }

        Arrays.sort(nums);
        helper(nums, results, subset);
        return results;
    }

    public void helper(int[] nums, List<List<Integer>> results, List<Integer> subset) {
        if (subset.size() == nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (subset.contains(nums[i])) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, results, subset);
            subset.remove(subset.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }
}
