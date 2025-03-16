import sys

N = int(sys.stdin.readline().strip())
points = [tuple(map(int, sys.stdin.readline().split())) for _ in range(N)]

# 정렬: y좌표 오름차순, y좌표가 같으면 x좌표 오름차순
points.sort(key=lambda p: (p[1], p[0]))

for x, y in points:
    print(x, y)
