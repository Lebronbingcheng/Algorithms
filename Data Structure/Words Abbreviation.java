public class Solution {
    /**
     * @param dict an array of n distinct non-empty strings
     * @return an array of minimal possible abbreviations for every word
     */
    public String[] wordsAbbreviation(String[] dict) {
        // Write your code here
        if (dict == null || dict.length == 0) {
            return new String[0];
        }
        int len = dict.length;
        String[] res = new String[len];
        List<Integer> indexs = new ArrayList<>();
        int reserve = 2;
        for (int i = 0; i < len; i++) {
            indexs.add(i);
        }
        int prefix = 2;
        while (!indexs.isEmpty()) {
            Map<String, Set<Integer>> map = new HashMap<>();
            for (int i : indexs) {
                String s = dict[i];
                String abbr = abbr(prefix, s);
                if (map.containsKey(abbr)) {
                    map.get(abbr).add(i);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    map.put(abbr, set);
                }
            }
            List<Integer> next = new ArrayList<>();
            for (String word : map.keySet()) {
                if (map.get(word).size() == 1) {
                    int index = -1;
                    for (int i : map.get(word)) {
                        index = i;
                    }
                    res[index] = word;
                } else {
                    for (int i : map.get(word)) {
                        next.add(i);
                    }
                }
            }
            indexs = next;
            prefix++;
        }
        return res;
    }

    public static String abbr(int prefix, String s) {
        int len = s.length();
        if (len <= prefix + 1) {
            return s;
        }
        return s.substring(0, prefix - 1) + (len - prefix) + s.charAt(len - 1);
    }
}
