class Solution(object):
    def canCross(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """
        n = len(stones)
        sets = [set() for _ in range(n)]
        for i in range(len(stones)):
            if i == 0:
                sets[i].update([1])
            else:
                for j in range(i):
                    diff = stones[i] - stones[j]
                    if diff in sets[j]:
                        sets[i].update([diff, diff+1, diff-1])
        
        if sets[n - 1]:
            return True
        return False
                    


def main():
    # Accepting space-separated numbers from user input
    user_input = input()

    # Converting the input string into a list of integers
    stones_list = [int(item) for item in user_input.split()]

    # Creating a Solution instance
    solution = Solution()

    # Calling the canCross method and printing the result
    print(solution.canCross(stones_list))



if __name__ == "__main__":
    main()