class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        list.add(matrix[0][0]);
        int x = 0;
        int y = 1;
        int[] result = new int[matrix.length * matrix[0].length];
        if (matrix.length == 1) {
            for (int[] tempresult : matrix) {
                result = tempresult;
            }
            return result;
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                result[i] = matrix[i][0];
            }
            return result;
        }
        while(list.size() < matrix.length * matrix[0].length) {
            while (isInBound(matrix, x, y)) {
                if (list.size() ==  matrix.length * matrix[0].length) {
                    break;
                }
                list.add(matrix[x][y]);
                x += 1;
                y -= 1;
            }
            x -= 1;
            y += 1;
            if (isInBound(matrix, x + 1, 0)) {
                x += 1;
            } else {
                y += 1;
            }
            while (isInBound(matrix, x, y)) {
                if (list.size() ==  matrix.length * matrix[0].length) {
                    break;
                }
                list.add(matrix[x][y]);
                x -= 1;
                y += 1;
            }
            x += 1;
            y -= 1;
            if (isInBound(matrix, x, y + 1)) {
                y += 1;
            } else {
                x += 1;
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private boolean isInBound(int[][] matrix, int x, int y) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (x < 0 || x >= n) {
            return false;
        }
        if (y < 0 || y >= m) {
            return false;
        }
        return true;
    }
 }
