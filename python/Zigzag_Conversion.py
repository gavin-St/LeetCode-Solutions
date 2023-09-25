class Solution(object):
    def convert(self, s: str, numRows: int):
        if numRows == 1: return s

        curRow = 1
        curCol = 1
        diagonal = False
        prevDiagRow = -1
        prevDiagCol = -1
        i = 0
        ans = [[] for i in range(numRows)]
        print(s)
        while i < len(s):
            print(str(i) +" " + str(curRow) + " " + str(curCol))
            if diagonal:
                if curRow == prevDiagRow - 1 and curCol == prevDiagCol + 1:
                    # print(s[i])
                    ans[curRow-1].append(s[i])
                    i += 1
                    if curRow == 1:
                        diagonal = False
                        curRow += 1
                    else:
                        prevDiagCol = curCol
                        prevDiagRow = curRow
                        curRow -= 1
                else:
                    if curRow == 1:
                        curCol += 1
                        curRow = numRows
                    else:
                        curRow -= 1
            else:
                ans[curRow-1].append(s[i])
                # print(s[i])
                i += 1
                if curRow == numRows:                    
                    diagonal = True
                    prevDiagCol = curCol
                    curCol += 1
                    prevDiagRow = curRow
                else:
                    curRow += 1

        finalAns = ""

        for i in range (numRows):
            for j in range (len(ans[i])):
                finalAns += ans[i][j]
        return finalAns
        print(finalAns)



def main():
    # Accepting space-separated numbers from user input
    user_input = input()

    # Converting the input string into a list of integers
    stones_list = user_input.split()

    # Creating a Solution instance
    solution = Solution()

    # Calling the canCross method and printing the result
    print(solution.convert(stones_list[0], int(stones_list[1])))



if __name__ == "__main__":
    main()