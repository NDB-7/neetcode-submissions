import copy

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        cp = copy.deepcopy(matrix)
        
        for j, row in enumerate(matrix):
            for i, cell in enumerate(row):
                if cell == 0:
                    for c_j in range(0, len(matrix)):
                        cp[c_j][i] = 0
                    for c_i in range(0, len(matrix[0])):
                        cp[j][c_i] = 0

        for j, row in enumerate(cp):
            for i, cell in enumerate(row):
                matrix[j][i] = cell