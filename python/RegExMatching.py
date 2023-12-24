class Solution(object):
    def isMatch(self, s: str, p: str) -> bool:
        lens = len(s)
        lenp = len(p)
        dp = [[None for _ in range(lenp+1)] for _ in range(lens+1)]
        def check(s, p, a, b):
            if dp[a][b] is not None:
                return dp[a][b]
            if a >= lens or b >= lenp:
                if b < lenp - 1 and p[b+1] == '*':
                    dp[a][b] = check(s,p,a,b+2)
                    return dp[a][b]
                if a < lens or b < lenp:
                    # print(False)
                    return dp[a][b]
                # print(True)
                dp[a][b] = True
                return True
            elif p[b] == '*':
                if check(s, p, a, b+1):
                #    print(True)
                   dp[a][b] = True
                   return True
                prevp = p[b-1]
                # print("prevp",prevp)
                counter = 0
                while a + counter < lens and (prevp == '.' or s[a+counter] == prevp):
                    counter += 1
                    if check(s, p, a+counter, b+1):
                        # print(True)
                        dp[a][b] = True
                        return True
                # print(False)
                dp[a][b] = False
                return False
            elif p[b] == '.':
                # p = p[:b] + s[a] + p[b+1:] #p[a] = s[b]
                if b + 1 < lenp and p[b+1] == '*':
                    dp[a][b] = check(s, p, a, b+1)
                    return dp[a][b]
                else:
                    dp[a][b] = check(s, p, a+1, b+1)
                    return dp[a][b]
            elif b + 1 < lenp and p[b+1] == '*':
                dp[a][b] = check(s, p, a, b+1)
                return dp[a][b]
            elif p[b] != s[a]:
                # print(False)
                dp[a][b] = False
                return False
            else:
                dp[a][b] = check(s, p, a+1, b+1)
                return dp[a][b]
        return check(s, p, 0, 0)
        




class obj:
    def __init__(self, s, p, a, b):
        self.s = s
        self.p = p
        self.x = a
        self.y = b
    def pr(self):
        print(self.s,self.p,self.x,self.y)   

def main():
    solution = Solution()
    print(solution.isMatch("aa", "a*b*c*"))



if __name__ == "__main__":
    main()