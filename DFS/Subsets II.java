public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        helper(nums, results, subset, 0);
        return results;
    }

    private void helper(int[] nums, List<List<Integer>> results, List<Integer> subset, int startIndex) {
        results.add(new ArrayList<>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, results, subset, i + 1);
            subset.remove(subset.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }
}
