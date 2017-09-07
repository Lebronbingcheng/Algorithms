class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        if (grid[0][0] == 1) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] paths = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    paths[i][j] = 0;
                    continue;
                }
                if (!isInBound(grid, i - 1, j) && !isInBound(grid, i, j - 1)) {
                    paths[i][j] = 1;
                } else if (!isInBound(grid, i - 1, j)) {
                    paths[i][j] = paths[i][j - 1];
                } else if (!isInBound(grid, i, j - 1)) {
                    paths[i][j] = paths[i - 1][j];
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[n - 1][m - 1];
    }

    private boolean isInBound(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n) {
            return false;
        }
        if (j < 0 || j >= m) {
            return false;
        }
        return true;
    }
}
