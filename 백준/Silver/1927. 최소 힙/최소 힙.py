import heapq
import sys

# 한 번에 입력 받기
input = sys.stdin.read
data = input().split()

n = int(data[0])  # 첫 번째 값이 입력 개수
min_heap = []

# 숫자 처리
for num in map(int, data[1:]):  # 첫 번째 요소를 제외한 나머지를 숫자로 변환
    if num == 0:
        if not min_heap:
            print(0)
        else:
            print(heapq.heappop(min_heap))
    else:
        heapq.heappush(min_heap, num)
