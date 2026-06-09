class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, board);
            dfs(i, cols - 1, board);
        }

        for (int j = 0; j < cols; j++) {
            dfs(0, j, board);
            dfs(rows - 1, j, board);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'T';

        dfs(i - 1, j, board);
        dfs(i + 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}
/*
    DFS from edges
        i, j=0 and cols-1
        j, i=0 and rows-1

    In DFS:
        Return if OOB or space != O
        Mark O as T
        Repeat 4 dirs
    
    2D pass over board:
        Mark O as X
        Mark T as O
*/