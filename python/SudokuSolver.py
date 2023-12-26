class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        cols = [[] for _ in range(9)]
        for i in range(9):
            for j in range(9):
                cols[i].append(board[j][i])
        
        squares = []
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                square = [board[x][y] for x in range(i, i + 3) for y in range(j, j + 3)]
                squares.append(square)

        def map(i, j):
            return i // 3 * 3 + j // 3

        def solve(i, j):
            # print(i,j)
            if i > 8:
                return True
            if board[i][j] != '.':
                if i == 8 and j == 8:
                    return True
                elif j == 8:
                    return solve(i+1, 0)
                else:
                    return solve(i, j+1)
            else:
                for k in range(1,10):
                    # print("k", k)
                    if (not str(k) in board[i]) and (not str(k) in cols[j]) and (not str(k) in squares[map(i,j)]):
                        # print("board",board[i])
                        # print("cols",cols[j])
                        # print("squares",squares[map(i,j)])
                        board[i][j] = str(k)
                        cols[j][i] = str(k)
                        squares[map(i,j)].append(str(k))
                        if (j==8 and solve(i+1, 0)) or (j < 8 and solve(i, j+1)):
                            return True
                        else:
                            board[i][j] = '.'
                            cols[j][i] = '.'
                            del squares[map(i,j)][-1]
                return False
                        

        solve(0, 0)