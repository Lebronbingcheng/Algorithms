/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (graph == null || graph.size() == 0) {
            return -1;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(s);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode graph1 = queue.poll();
                if (graph1 == t) {
                    return result;
                }
                set.add(graph1);
                for (UndirectedGraphNode point : graph1.neighbors) {
                    if (set.contains(point)) {
                        continue;
                    }
                    queue.offer(point);
                }
            }
            result++;
        }
        return -1;
    }
}
