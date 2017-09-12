/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    private Point copy;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        copy = origin;
        Comparator<Point> sort = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (getDistance(a, copy) > getDistance(b, copy)) {
                    return -1;
                } else if (getDistance(a, copy) < getDistance(b, copy)) {
                    return 1;
                } else {
                    if (a.x > b.x) {
                        return -1;
                    } else if (a.x < b.x) {
                        return 1;
                    } else {
                        if (a.y > b.y) {
                            return -1;
                        } else if (a.y < b.y) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        };
        Queue<Point> queue = new PriorityQueue<Point>(k, sort);
        for (Point point : points) {
            queue.offer(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        //System.out.print(queue.size());
        Point[] result = new Point[k];
        for (int i = k - 1; i >= 0; i--) {
            //System.out.print(i);
            result[i] = queue.poll();
        }
        return result;
    }

    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
