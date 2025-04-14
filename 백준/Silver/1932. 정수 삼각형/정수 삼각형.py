n = int(input())
triangle = [list(map(int, input().split())) for _ in range(n)]

# 아래에서 위로 누적 최대 합 계산
for i in range(n - 2, -1, -1):  # 마지막에서 두 번째 줄부터 위로
    for j in range(i + 1):  # 현재 줄의 각 요소
        triangle[i][j] += max(triangle[i + 1][j], triangle[i + 1][j + 1])

# 최상단의 값이 최대 경로합
print(triangle[0][0])
