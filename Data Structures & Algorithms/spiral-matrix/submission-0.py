class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res = []

        def spiral(n, m, tl_i, tl_j): # tl = top left
            if n <= 0 or m <= 0:
                return
            if n == 1:
                for j in range(tl_j, tl_j + m):
                    res.append(matrix[tl_i][j])
                return
            if m == 1:
                for i in range(tl_i, tl_j + n):
                    res.append(matrix[i][tl_j])
                return
            
            for j in range(tl_j, tl_j + m):
                res.append(matrix[tl_i][j])
            for i in range(tl_i + 1, tl_i + n):
                res.append(matrix[i][tl_j + m - 1])
            for j in range(tl_j + m - 2, tl_j - 1, -1):
                res.append(matrix[tl_i + n - 1][j])
            for i in range(tl_i + n - 2, tl_i, -1):
                res.append(matrix[i][tl_j])

            spiral(n - 2, m - 2, tl_i + 1, tl_j + 1)

        spiral(len(matrix), len(matrix[0]), 0, 0)

        return res