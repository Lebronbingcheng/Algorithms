public class Solution {
    /*
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (array[0] == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            if (array[i - 1] != '0') {
                dp[i] = dp[i - 1];
            }
            int num = array[i - 1] - '0' + 10 * (array[i - 2] - '0');
            System.out.println(num);
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
