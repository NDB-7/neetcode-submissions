class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outgoing = new int[n];
        int[] incoming = new int[n];

        for (int[] rel : trust) {
            outgoing[rel[0] - 1]++;
            incoming[rel[1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (outgoing[i] == 0 && incoming[i] == n - 1) return i + 1;
        }

        return -1;
    }
}