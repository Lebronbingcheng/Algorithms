class Solution {
    int count = 0;
    public int countArrangement(int N) {
        if (N == 1) {
            return 1;
        }
        boolean[] used = new boolean[N + 1];
        used[0] = true;
        helper(used, N, 1);
        return count;
    }

    private void helper(boolean[] used, int N, int num) {
        if (num > N) {
            count++;
            return;
        }
        boolean isChange = false;
        for (int i = 1; i < used.length; i++) {
            if (isAllowed(used, i, num)) {
                used[i] = true;
                helper(used, N, num + 1);
                used[i] = false;
                isChange = true;
            }
        }
        if (isChange) {
            return;
        }
    }

    private boolean isAllowed(boolean[] used, int index, int num) {
        if (used[index]) {
            return false;
        }
        if (num % index != 0 && index % num != 0) {
            return false;
        }
        return true;
    }
}
