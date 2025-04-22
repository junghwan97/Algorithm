import sys

n = int(input())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

max_dp = arr[0][:]
min_dp = arr[0][:]

for i in range(1, n):
    next_max_dp = [0, 0, 0]
    next_min_dp = [0, 0, 0]

    # 최댓값 점화식
    next_max_dp[0] = max(max_dp[0], max_dp[1]) + arr[i][0]
    next_max_dp[1] = max(max_dp[0], max_dp[1], max_dp[2]) + arr[i][1]
    next_max_dp[2] = max(max_dp[1], max_dp[2]) + arr[i][2]

    # 최솟값 점화식
    next_min_dp[0] = min(min_dp[0], min_dp[1]) + arr[i][0]
    next_min_dp[1] = min(min_dp[0], min_dp[1], min_dp[2]) + arr[i][1]
    next_min_dp[2] = min(min_dp[1], min_dp[2]) + arr[i][2]

    # 갱신
    max_dp = next_max_dp[:]
    min_dp = next_min_dp[:]

print(max(max_dp), min(min_dp))