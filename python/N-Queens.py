from typing import List
import itertools

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def check(lst, n):
            for i in range(n):
                j = 1
                while i + j < n and lst[i] + j < n:
                    if lst[i + j] == lst[i] + j:
                        # print(1)
                        return False
                    j += 1
                j = 1
                while i + j < n and lst[i] - j >= 0:
                    if lst[i + j] == lst[i] - j: 
                        # print(2)
                        return False
                    j += 1
            return True
        
        def convert(lst, n):
            return [''.join('Q' if lst[i] == j else '.' for j in range(n)) for i in range(n)]
        
        ans = []
        for arr in itertools.permutations([i for i in range(n)]):
            # print(arr)
            if check(arr, n):
                ans.append(convert(arr, n))
        return ans

def main():
    solution = Solution()
    print(solution.solveNQueens(9))



if __name__ == "__main__":
    main()