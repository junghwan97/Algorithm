import sys

# 입력 받기
N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

# 누적 합 배열 생성
prefix_sum = [0] * (N + 1)  # 0번 인덱스 포함
for i in range(1, N + 1):
    prefix_sum[i] = prefix_sum[i - 1] + arr[i - 1]

for _ in range(M):
    i, j = map(int, sys.stdin.readline().split())
    print(prefix_sum[j] - prefix_sum[i - 1])  # O(1)로 구간 합 계산
