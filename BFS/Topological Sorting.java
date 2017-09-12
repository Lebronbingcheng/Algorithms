/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if (graph == null || graph.size() == 0) {
            return graph;
        }
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode point : graph) {
            map.put(point, 0);
        }
        for (DirectedGraphNode head : graph) {
            for (DirectedGraphNode point : head.neighbors) {
                int value = map.get(point) + 1;
                map.put(point, value);
            }
        }
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode head : graph) {
            if (map.get(head) == 0) {
                queue.offer(head);
            }
        }
        while (!queue.isEmpty()) {
            DirectedGraphNode point = queue.poll();
            if (!result.contains(point)) {
                result.add(point);
            }
            for (DirectedGraphNode check : point.neighbors) {
                int v = map.get(check) - 1;
                map.put(check, v);
                if (v == 0) {
                    queue.offer(check);
                }
            }
        }
        return result;
    }
}
