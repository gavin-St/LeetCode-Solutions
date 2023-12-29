class Solution(object):
    def isMatch(self, s: str, p: str) -> bool:
        
        sp = 0
        words = p.split('*')
        while words[0] != '' and sp < len(words[0]) and sp < len(s):
            if s[sp] != words[0][sp] and words[0][sp] != '?':
                    return False
            sp += 1
            if sp == len(s) and sp < len(words[0]): return False
        del words[0]
        # print(words)
        for w in words:
            if len(w) == 0: continue
            prev = sp
            i = 0
            while sp < len(s) and i < len(w):
                # print(sp, i)
                # print(s[sp], w[i])
                if s[sp] == w[i] or w[i] == '?':
                    i += 1
                else:
                    i = 0
                    sp = prev
                    prev += 1
                sp += 1
            if i < len(w):
                return False
        if len(p) == 0:
            return len(s) == 0
        if len(s) == 0:
            for pp in p:
                 if pp != '*': return False
            return True
        if sp >= len(s) or p[-1] == '*': return True

        if len(words) > 0:
            a = len(s) - len(words[-1])
            b = 0
            while b < len(words[-1]):
                if s[a+b] != words[-1][b] and words[-1][b] != '?':
                        return False
                b += 1
        else: return False
        return True
    


def main():
    solution = Solution()
    print(solution.isMatch("hi",
                            "*?"))



if __name__ == "__main__":
    main()