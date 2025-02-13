import sys

def solve():
    # 최대 100까지 미리 계산
    dp = [0] * 101
    dp[1], dp[2], dp[3] = 1, 1, 1
    dp[4], dp[5] = 2, 2
    
    for i in range(6, 101):
        dp[i] = dp[i-1] + dp[i-5]
    
    # 입력 처리
    T = int(sys.stdin.readline())
    for _ in range(T):
        N = int(sys.stdin.readline())
        print(dp[N])

if __name__ == "__main__":
    solve()