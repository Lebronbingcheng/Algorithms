class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ) {
            return list;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] used = new boolean[n][m];
        int x = 0;
        int y = 0;
        while (list.size() < n * m) {
            while (y < m && !used[x][y]) {
                list.add(matrix[x][y]);
                used[x][y] = true;
                y += 1;
            }
            y -= 1;
            x += 1;
            while (x < n && !used[x][y]) {
                list.add(matrix[x][y]);
                used[x][y] = true;
                x += 1;
            }
            x -= 1;
            y -= 1;
            while (y >= 0 && !used[x][y]) {
                list.add(matrix[x][y]);
                used[x][y] = true;
                y -= 1 ;
            }
            y += 1;
            x -= 1;
            while (x >= 0 && !used[x][y]) {
                list.add(matrix[x][y]);
                used[x][y] = true;
                x -= 1;
            }
            x += 1;
            y += 1;
        }
        return list;
    }
}
