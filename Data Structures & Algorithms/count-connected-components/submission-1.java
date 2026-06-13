class Solution {
    int[] par, rank;

    public int countComponents(int n, int[][] edges) {
        par = new int[n];
        rank = new int[n];

        // Fill up arrays
        for (int i = 0; i < n; i++) par[i] = i;
        Arrays.fill(rank, 1);

        int res = n;

        for (int[] edge : edges) {
            res -= union(edge[0], edge[1]);
        }

        return res;
    }

    private int find(int n) {
        int res = n;

        while (res != par[res]) {
            par[res] = par[par[res]];
            res = par[res];
        }

        return res;
    }

    private int union(int n1, int n2) {
        int par1 = find(n1), par2 = find(n2);
        if (par1 == par2) return 0;

        if (rank[par2] > rank[par1]) {
            par[par1] = par2;
            rank[par2] += rank[par1];
        } else {
            par[par2] = par1;
            rank[par1] += rank[par2];
        }

        return 1;
    }
}
