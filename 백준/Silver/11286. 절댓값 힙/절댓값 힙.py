import sys
import heapq

input = sys.stdin.readline
n = int(input())
heap = []

for _ in range(n):
    x = int(input())
    if x != 0:
        heapq.heappush(heap, (abs(x), x))  # 절댓값 기준으로 우선순위 설정
    else:
        if heap:
            print(heapq.heappop(heap)[1])  # 두 번째 값이 실제 값
        else:
            print(0)
