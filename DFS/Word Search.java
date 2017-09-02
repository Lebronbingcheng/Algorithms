public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int n = board.length;
        int m = board[0].length;
        boolean[][] used = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean temp = exist(board, word, 0, i, j, used);
                    if (temp) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int index, int x, int y, boolean[][] used) {
        if (index == word.length()) {
            return true;
        }
        if (!isInBound(board, x, y, used)) {
            return false;
        }
        if (word.charAt(index) != board[x][y]) {
            return false;
        }
        used[x][y] = true;
        boolean findDown = exist(board, word, index + 1 , x + 1, y, used);
        if (findDown) {
            return true;
        }
        boolean findTop = exist(board, word, index + 1 , x - 1, y, used);
        if (findTop) {
            return true;
        }
        boolean findRight = exist(board, word, index + 1 , x, y + 1, used);
        if (findRight) {
            return true;
        }
        boolean findLeft = exist(board, word, index + 1, x, y - 1, used);
        if (findLeft) {
            return true;
        }
        used[x][y] = false;
        return false;
    }

    private boolean isInBound(char[][] board, int x, int y, boolean[][] used) {
        int n = board.length;
        int m = board[0].length;
        if (x < 0 || x >= n) {
            return false;
        }
        if (y < 0 || y >= m) {
            return false;
        }
        if (used[x][y]) {
            return false;
        }
        return true;
    }
}
