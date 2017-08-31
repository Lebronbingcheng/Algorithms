public class Solution {
    /**i
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (s.length() == 0 || s == null) {
            return results;
        }
        List<String> list = new ArrayList<>();
        helper(s, results, list, 0);
        return results;
    }

    private void helper(String s, List<List<String>> results, List<String> list, int startIndex) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s.substring(startIndex, i + 1))) {
                list.add(s.substring(startIndex, i + 1));
                helper(s, results, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
