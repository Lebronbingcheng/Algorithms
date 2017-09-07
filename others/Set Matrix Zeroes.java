class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> setRow = new ArrayList<>();
        List<Integer> setColumn = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (!setRow.contains(i)) {
                        setRow.add(i);
                    }
                    if (!setColumn.contains(j)) {
                        setColumn.add(j);
                    }
                }
            }
        }
        for (int row : setRow) {
            changeRow(matrix, row);
        }
        for (int column : setColumn) {
            changeColumn(matrix, column);
        }
    }

    private void changeRow(int[][] grid, int row) {
        int m = grid[row].length;
        for (int i = 0; i < m; i++) {
            grid[row][i] = 0;
        }
    }

    private void changeColumn(int[][] grid, int column) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            grid[i][column] = 0;
        }
    }
}
