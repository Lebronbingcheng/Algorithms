class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid a chessboard included 0 and 1
     * @return the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] xDirect = new int[]{1, -1, 2, -2};
        int[] yDirect = new int[]{2, 2, 1, 1};
        int n = grid.length;
        int m = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == n - 1 && point.y == m - 1) {
                    return result;
                }
                for (int j = 0; j < xDirect.length; j++) {
                    Point adj = new Point(point.x + xDirect[j], point.y + yDirect[j]);
                    if (!isInBound(adj, grid)) {
                        continue;
                    }
                    queue.offer(adj);
                    grid[adj.x][adj.y] = true;
                }
            }
            result++;
        }
        return -1;
    }

    private boolean isInBound(Point point, boolean[][] grid) {
        int x = point.x;
        int y = point.y;
        int n = grid.length;
        int m = grid[0].length;
        if (x < 0 || x >= n) {
            return false;
        }
        if (y < 0 || y >= m) {
            return false;
        }
        return grid[x][y] == false;
    }
}
