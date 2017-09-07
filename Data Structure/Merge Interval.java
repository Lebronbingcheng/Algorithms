/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        int size = intervals.size();
        Comparator<Interval> sort = new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start < i2.start) {
                    return -1;
                } else if (i1.start > i2.start) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Queue<Interval> queue = new PriorityQueue<>(size, sort);
        for (Interval interval : intervals) {
            queue.offer(interval);
        }
        List<Interval> result = new ArrayList<>();
        result.add(queue.poll());
        while (!queue.isEmpty()) {
            int lastPos = result.size() - 1;
            Interval head = queue.poll();
            if (isOverlap(result.get(lastPos), head)) {
                int start = result.get(lastPos).start;
                int end = Math.max(head.end, result.get(lastPos).end);
                result.remove(lastPos);
                result.add(new Interval(start, end));
            } else {
                result.add(head);
            }
        }
        return result;
    }

    private boolean isOverlap(Interval i1, Interval i2) {
        return i1.end >= i2.start;
    }
}
