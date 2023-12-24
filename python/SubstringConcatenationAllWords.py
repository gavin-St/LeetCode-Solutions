from typing import List

def set_ith_bit(number: int, i: int) -> int:
    if i < 0: return 0
    mask = 1 << i  # Create a mask with 1 at the nth bit
    number_with_bit_set = number | mask  # Set the nth bit using OR
    return number_with_bit_set

def clear_ith_bit(number: int, i: int) -> int:
    if i < 0: return 0
    mask = ~(1 << i)  # Create a mask with 0 at the nth bit and 1s elsewhere
    number_with_bit_cleared = number & mask  # Clear the nth bit using AND
    return number_with_bit_cleared

class Solution(object):
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
       
        window_len = len(words[0])
        total_len = window_len * len(words)
        word_map = {}
        for i in range(len(words)):
            word_map[words[i]] = i
        sw = [[0 for _ in range(len(words))] for _ in range(window_len)]
        ans = []

        for i in range(len(s)):
            print("hi", i)
            print(sw)
            substring = s[i:i+window_len]
            if len(substring) < window_len: break
            val = word_map.get(substring, -1)

            window_pos = i % window_len
            if i < total_len:
                if val >= 0: sw[window_pos][val] += 1
            else: 
                prev = i - total_len
                prev_val = word_map.get(s[prev : prev+window_len], -1)
                if prev_val >= 0:
                    sw[window_pos][prev_val] -= 1
                if val >= 0: sw[window_pos][val] += 1

            

            valid = True
            for arr in sw[window_pos]:
                if arr != 1: valid = False

            if valid:
                ans.append(i - total_len + window_len)

        return ans


def main():
    # Creating a Solution instance
    solution = Solution()

    # Calling the canCross method and printing the result
    print(solution.findSubstring("barfoothefoobarman", ["foo","bar"]))

if __name__ == "__main__":
    main()