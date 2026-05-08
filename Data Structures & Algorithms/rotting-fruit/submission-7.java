class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] DIRS = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;
        int lvlRemainder = q.size();

        while (!q.isEmpty()) {
            if (lvlRemainder == 0) {
                lvlRemainder = q.size();
                time += 1;
            }

            int[] loc = q.poll();
            int i = loc[0], j = loc[1];

            for (int[] DIR : DIRS) {
                int newI = i + DIR[0], newJ = j + DIR[1];
                if (newI < 0 || newJ < 0 || newI >= rows || newJ >= cols || grid[newI][newJ] != 1) continue;
                fresh--;
                grid[newI][newJ] = 2;
                q.offer(new int[]{newI, newJ});
            }

            lvlRemainder--;
        }

        return fresh == 0 ? time : -1;
    }
}
