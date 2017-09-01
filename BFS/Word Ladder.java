public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict.size() == 0) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        dict.add(start);
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(start);
        set.add(start);
        int result = 1;
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return result;
                    }
                    queue.offer(nextWord);
                    set.add(nextWord);
                }
            }
        }
        return 0;
    }

    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> newWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                char[] array = word.toCharArray();
                array[i] = c;
                String nextWord = new String(array);
                if (dict.contains(nextWord)) {
                     newWords.add(nextWord);
                }
            }
        }
        return newWords;
    }
}
