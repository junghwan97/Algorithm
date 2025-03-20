import sys
import heapq

input = sys.stdin.readline

heap = []
n = int(input().strip())

for _ in range(n):
    m = int(input().strip())
    if m == 0:
        if heap:
            print(-heapq.heappop(heap))  # 최대 힙이므로 -값을 출력
        else:
            print(0)
    else:
        heapq.heappush(heap, -m)  # 최대 힙 구현을 위해 -m 저장
