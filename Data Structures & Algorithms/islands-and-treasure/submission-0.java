class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        List<int[]> chests = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) chests.add(new int[]{i, j});
            }
        }

        for (int[] chest : chests) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[rows][cols];
            q.offer(new int[]{chest[0], chest[1], 0});
            while (!q.isEmpty()) {
                int[] loc = q.poll();
                int i = loc[0], j = loc[1];
                if (i >= 0 && j >= 0 && i < rows && j < cols && grid[i][j] != -1 && !visited[i][j]) {
                    visited[i][j] = true;
                    grid[i][j] = Math.min(loc[2], grid[i][j]);
                    q.offer(new int[]{i + 1, j, loc[2] + 1});
                    q.offer(new int[]{i - 1, j, loc[2] + 1});
                    q.offer(new int[]{i, j + 1, loc[2] + 1});
                    q.offer(new int[]{i, j - 1, loc[2] + 1});
                }
            }
        }
    }
}
