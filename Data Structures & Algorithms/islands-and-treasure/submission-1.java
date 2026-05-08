class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) q.offer(new int[]{i, j, 0});
            }
        }

        while (!q.isEmpty()) {
            int[] loc = q.poll();
            int i = loc[0], j = loc[1];
            if (i >= 0 && j >= 0 && i < rows && j < cols && (grid[i][j] == Integer.MAX_VALUE || grid[i][j] == 0)) {
                if (grid[i][j] == Integer.MAX_VALUE) grid[i][j] = loc[2];
                q.offer(new int[]{i + 1, j, loc[2] + 1});
                q.offer(new int[]{i - 1, j, loc[2] + 1});
                q.offer(new int[]{i, j + 1, loc[2] + 1});
                q.offer(new int[]{i, j - 1, loc[2] + 1});
            }
        }
    }
}
