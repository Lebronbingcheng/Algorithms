/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] records) {
        // Write your code here
        Map<Integer, Double> result = new HashMap<>();
        if (records == null || records.length == 0) {
            return result;
        }
        Map<Integer, PriorityQueue<Double>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (Record record : records) {
            int id = record.id;
            int score = record.score;
            if (!map.containsKey(id)) {
                PriorityQueue<Double> queue = new PriorityQueue<Double>();
                queue.offer((double)score);
                map.put(id, queue);
                list.add(id);
            } else {
                PriorityQueue<Double> queue = map.get(id);
                queue.offer((double)score);
                if (queue.size() > 5) {
                    queue.poll();
                }
                map.put(id, queue);
            }
        }
        for (int id : list) {
            double ave = getAverage(map.get(id));
            result.put(id, ave);
        }
        return result;
    }

    private double getAverage(PriorityQueue<Double> queue) {
        double sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        return sum / 5;
    }
}
