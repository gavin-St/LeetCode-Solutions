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
            p = word_map.get(words[i], 0)
            word_map[words[i]] = p+1
        sw = [{} for _ in range(window_len)]
        ans = []
        # print(word_map)
        for i in range(len(s)):
            # print("hi", i)
            # print(sw)
            substring = s[i:i+window_len]
            if len(substring) < window_len: break

            window_pos = i % window_len
            if substring in word_map:
                p = sw[window_pos].get(substring, 0)
                sw[window_pos][substring] = p + 1

            if i >= total_len: 
                prev = i - total_len
                prev_word = s[prev : prev + window_len]
                if prev_word in word_map:
                    sw[window_pos][prev_word] -= 1


            valid = True
            for key, value in word_map.items():
                # print(key, value)
                if value != sw[window_pos].get(key, -1): valid = False

            if valid:
                # print(i)
                ans.append(i - total_len + window_len)

        return ans


def main():
    solution = Solution()

    # Calling the canCross method and printing the result
    print(solution.findSubstring("barfoothefoobarman", ["foo","bar"]))

if __name__ == "__main__":
    main()