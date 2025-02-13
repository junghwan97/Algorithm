import sys

def solve():
    dp = [0] * 101
    dp[1], dp[2], dp[3] = 1, 1, 1
    dp[4], dp[5] = 2, 2
    
    for i in range(6, 101):
        dp[i] = dp[i-1] + dp[i-5]
    
    T = int(sys.stdin.readline().strip())
    for _ in range(T):
        N = int(sys.stdin.readline().strip())
        print(dp[N])

solve()