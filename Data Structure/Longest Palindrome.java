public class Solution {
    /*
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        if (s.length() == 0) {
            return 0;
        }
        int result = 0;
        int[] map = new int[256];
        char[] sa = s.toCharArray();
        for (char c : sa) {
            map[c] = map[c] + 1;
            if (map[c] % 2 == 0) {
                result++;
            }
        }
        if (result * 2 == s.length()) {
            return result * 2;
        }
        return result * 2 + 1;
    }
}
