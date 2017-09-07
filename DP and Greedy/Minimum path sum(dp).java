class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] sums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sums[i][j] = Integer.MAX_VALUE;
            }
        }
        sums[0][0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isInBound(grid, i, j + 1)) {
                    if (sums[i][j] + grid[i][j + 1] < sums[i][j + 1]) {
                        sums[i][j + 1] = sums[i][j] + grid[i][j + 1];
                    }
                }
                if (isInBound(grid, i + 1, j)) {
                    if (sums[i][j] + grid[i + 1][j] < sums[i + 1][j]) {
                        sums[i + 1][j] = sums[i][j] + grid[i + 1][j];
                    }
                }
            }
        }
        return sums[n - 1][m - 1];
    }

    private boolean isInBound(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        if (x < 0 || x >= n) {
            return false;
        }
        if (y < 0 || y >= m) {
            return false;
        }
        return true;
    }
}
