import sys

def fibonacci_count(n):
    # DP 테이블 초기화 (최대 40까지 저장 가능)
    count_0 = [0] * (41)
    count_1 = [0] * (41)

    # 초기값 설정
    count_0[0], count_1[0] = 1, 0
    count_0[1], count_1[1] = 0, 1

    # DP 진행
    for i in range(2, 41):
        count_0[i] = count_0[i-1] + count_0[i-2]
        count_1[i] = count_1[i-1] + count_1[i-2]

    return count_0, count_1

# 입력 받기
t = int(sys.stdin.readline().strip())
cases = [int(sys.stdin.readline().strip()) for _ in range(t)]

# DP 테이블 미리 계산
count_0, count_1 = fibonacci_count(40)

# 결과 출력
for n in cases:
    print(count_0[n], count_1[n])