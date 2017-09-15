public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] degree = new int[numCourses];
        List[] adj = new ArrayList[numCourses];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int head = queue.poll();
            result[index] = head;
            index++;
            for (int i = 0; i < adj[head].size(); i++) {
                int num = (int)adj[head].get(i);
                degree[num]--;
                if (degree[num] == 0) {
                    queue.offer(num);
                }
            }
        }
        if (index == numCourses) {
            return result;
        }
        return new int[0];
    }
}
