MOD = 10007

def tile(n):
    dp = [0] * (n + 1)
    dp[1] = 1
    if n >= 2:
        dp[2] = 3

    for i in range(3, n + 1):
        dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % MOD

    return dp[n]

n = int(input())
print(tile(n))
