import sys
input = sys.stdin.readline

# 입력: 배열 크기 n, 쿼리 개수 m
n, m = map(int, input().split())

# 2차원 배열 입력 받기 
arr = [ [0] * (n + 1) ]
for _ in range(n):
    arr.append([0] + list(map(int, input().split())))

# 누적합 배열 dp 초기화
dp = [[0] * (n + 1) for _ in range(n + 1)]

# 누적합 dp 채우기
for i in range(1, n + 1):
    for j in range(1, n + 1):
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i][j]

for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    res = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]
    print(res)
