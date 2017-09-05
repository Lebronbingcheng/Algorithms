class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        helper(results, "", n, n);
        return results;
    }

    private void helper(List<String> results, String pan, int left, int right) {
        if (left == 0 && right == 0) {
            System.out.println(pan);
            results.add(pan);
            return;
        }
        if (left > 0) {
            helper(results, pan + "(", left - 1, right);
        }
        if (right > 0 && left < right) {
            helper(results, pan + ")", left, right - 1);
        }
    }
}
