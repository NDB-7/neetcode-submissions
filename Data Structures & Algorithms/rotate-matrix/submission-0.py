class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        matrix.reverse()
        
        n = len(matrix)

        for j in range(n):
            for i in range(j, n):
                t = matrix[j][i]
                matrix[j][i] = matrix[i][j]
                matrix[i][j] = t