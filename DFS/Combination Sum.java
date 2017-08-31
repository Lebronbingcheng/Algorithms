public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        List<Integer> subset = new ArrayList<>();
        helper(candidates, target, results, subset, 0);
        return results;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> results, List<Integer> subset, int startIndex) {
        if (target == 0) {
            results.add(new ArrayList<>(subset));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            subset.add(candidates[i]);
            helper(candidates, target - candidates[i], results, subset, i);
            subset.remove(subset.size() - 1);
            while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
                i++;
            }
        }
    }
}
