class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];

            for (int[] DIR : DIRS) {
                int newI = i + DIR[0], newJ = j + DIR[1];
                if (newI >= 0 && newJ >= 0 && newI < rows && newJ < cols && grid[newI][newJ] == Integer.MAX_VALUE) {
                    grid[newI][newJ] = grid[i][j] + 1;
                    q.offer(new int[]{newI, newJ});
                }
            }
        }
    }
}
