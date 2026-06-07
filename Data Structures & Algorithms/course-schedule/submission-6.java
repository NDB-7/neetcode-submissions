class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        
        int[] visitState = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adj, visitState)) return false;
        }

        return true;
    }

    private boolean hasCycle(int i, List<List<Integer>> adj, int[] visitState) {
        if (visitState[i] == 1) return true;
        if (visitState[i] == 2) return false;

        visitState[i] = 1;

        for (int n : adj.get(i)) {
            if (hasCycle(n, adj, visitState)) return true;
        }

        visitState[i] = 2;

        return false;
    }
}
