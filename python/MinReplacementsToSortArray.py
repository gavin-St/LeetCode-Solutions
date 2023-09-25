class Solution(object):
    def minimumReplacement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        prev = nums[n-1]
        ans = 0
        for i in range (n-2, -1, -1):
            if prev >= nums[i]:
                prev = nums[i]
                continue
            divisions = (nums[i] // prev) + (nums[i] % prev > 0)
            ans += divisions-1
            prev = nums[i] // divisions
            # print("prev", prev)
            # print("ans", ans)
        return ans


def main():
    # Accepting space-separated numbers from user input
    user_input = input()

    # Converting the input string into a list of integers
    list = [int(item) for item in user_input.split()]

    # Creating a Solution instance
    solution = Solution()

    # Calling the canCross method and printing the result
    print(solution.minimumReplacement(list))



if __name__ == "__main__":
    main()