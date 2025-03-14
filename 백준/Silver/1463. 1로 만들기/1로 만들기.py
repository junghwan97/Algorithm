N = int(input())  # 입력값
dp = [0] * (N + 1)  # dp 테이블 초기화

for i in range(2, N + 1):
    dp[i] = dp[i - 1] + 1  # 기본적으로 1을 빼는 경우

    if i % 2 == 0:  # 2로 나누어 떨어질 때
        dp[i] = min(dp[i], dp[i // 2] + 1)
        
    if i % 3 == 0:  # 3으로 나누어 떨어질 때
        dp[i] = min(dp[i], dp[i // 3] + 1)

print(dp[N])