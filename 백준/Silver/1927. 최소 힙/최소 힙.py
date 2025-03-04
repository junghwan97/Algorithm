import heapq
import sys

n = int(sys.stdin.readline())
min_heap = []
for i in range(n):
    num = int(sys.stdin.readline())
    if num == 0:
        if len(min_heap) == 0:
            print(0)
        else:
            removed = heapq.heappop(min_heap)
            print(removed)
    else:
        heapq.heappush(min_heap, num)
