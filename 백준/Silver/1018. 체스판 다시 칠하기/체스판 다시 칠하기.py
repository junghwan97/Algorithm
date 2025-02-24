# 입력 받기
N, M = map(int, input().split())
board = [input().strip() for _ in range(N)]

min_count = float('inf')  # 최소 수정 횟수 저장

# 8×8 부분 보드 탐색
for i in range(N - 7):
    for j in range(M - 7):
        count1 = 0  # 패턴 1 (왼쪽 위 'W')
        count2 = 0  # 패턴 2 (왼쪽 위 'B')

        # 8×8 보드 내에서 칸 비교
        for x in range(8):
            for y in range(8):
                current = board[i + x][j + y]
                if (x + y) % 2 == 0:  # 짝수 위치
                    if current != 'W':
                        count1 += 1
                    if current != 'B':
                        count2 += 1
                else:  # 홀수 위치
                    if current != 'B':
                        count1 += 1
                    if current != 'W':
                        count2 += 1

        # 두 패턴 중 최소 변경 횟수 갱신
        min_count = min(min_count, count1, count2)

# 최소 변경 횟수 출력
print(min_count)
