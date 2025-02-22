import sys

input = sys.stdin.readline
N, M = map(int, input().split())
trees = list(map(int, input().split()))

# 이분 탐색을 위한 초기 범위 설정이다.
start, end = 0, max(trees)
result = 0

while start <= end:
    mid = (start + end) // 2  # 현재 절단 높이이다.
    # mid 높이에서 잘리는 나무의 총합을 계산한다.
    total = sum(tree - mid for tree in trees if tree > mid)
    
    if total >= M:  
        # 조건을 만족하므로 현재 mid 값을 저장하고,
        # 더 높은 절단 높이를 찾기 위해 start 값을 조정한다.
        result = mid
        start = mid + 1
    else:
        # 조건을 만족하지 않으므로, H를 낮추기 위해 end 값을 조정한다.
        end = mid - 1

print(result)