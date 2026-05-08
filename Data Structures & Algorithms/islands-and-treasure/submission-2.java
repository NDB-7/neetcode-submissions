class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] loc = q.poll();
            int i = loc[0], j = loc[1];

            for (int[] DIR : DIRS) {
                int newI = i + DIR[0];
                int newJ = j + DIR[1];
                if (newI < 0 || newJ < 0 || newI >= rows || newJ >= cols || grid[newI][newJ] != Integer.MAX_VALUE) continue;
                grid[newI][newJ] = grid[i][j] + 1;
                q.offer(new int[]{newI, newJ});
            }
        }
    }
}
