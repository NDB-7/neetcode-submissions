class Solution {
    int[] parent;
    int[] rank;

    public int countComponents(int n, int[][] edges) {
        int res = n;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) res--;
        }

        return res;
    }
    
    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;

        if (rank[px] > rank[py]) {
            int temp = py;
            py = px;
            px = temp;
        }

        rank[py] += rank[px];
        parent[px] = py;

        return true;
    }

    // Start with n individual nodes (sets)
    // Union them together based on edges[]
    // Initial number of sets (res) is n
    // Each union decrements res
    // Implement with union find algorithm
    // Parent[i] table stores a representative node of the set
    // Rank[rep] table stores the size of the set
    // Union(int x, int y) to union based on rank (smaller becomes child of larger, add ranks)
    // Find(int x) to get parent
}
