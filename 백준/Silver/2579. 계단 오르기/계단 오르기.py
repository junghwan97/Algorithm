import sys

# 입력
n = int(sys.stdin.readline().strip())
score = [int(sys.stdin.readline().strip()) for _ in range(n)]

# 예외 처리 (계단이 1개일 경우)
if n == 1:
    print(score[0])
    exit()

# DP 테이블 초기화
dp = [0] * n
dp[0] = score[0]
dp[1] = score[0] + score[1]

if n > 2:
    dp[2] = max(score[0] + score[2], score[1] + score[2])

# DP 점화식 적용
for i in range(3, n):
    dp[i] = max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i])

# 결과 출력
print(dp[n-1])
