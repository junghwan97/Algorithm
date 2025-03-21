import heapq
import sys

input = sys.stdin.readline

def process_operations(k):
    min_heap = []
    max_heap = []
    deleted = {}

    for _ in range(k):
        cmd, num = input().split()
        num = int(num)

        if cmd == 'I':
            heapq.heappush(min_heap, num)
            heapq.heappush(max_heap, -num)
            deleted[num] = deleted.get(num, 0) + 1

        elif cmd == 'D':
            if num == 1:  # 최대값 삭제
                while max_heap:
                    x = -heapq.heappop(max_heap)
                    if deleted.get(x, 0) > 0:
                        deleted[x] -= 1
                        break
            elif num == -1:  # 최소값 삭제
                while min_heap:
                    x = heapq.heappop(min_heap)
                    if deleted.get(x, 0) > 0:
                        deleted[x] -= 1
                        break

    # 유효하지 않은 값 제거
    while min_heap and deleted.get(min_heap[0], 0) == 0:
        heapq.heappop(min_heap)
    while max_heap and deleted.get(-max_heap[0], 0) == 0:
        heapq.heappop(max_heap)

    if min_heap and max_heap:
        print(-max_heap[0], min_heap[0])
    else:
        print("EMPTY")

# 테스트케이스 처리
t = int(input())
for _ in range(t):
    k = int(input())
    process_operations(k)
