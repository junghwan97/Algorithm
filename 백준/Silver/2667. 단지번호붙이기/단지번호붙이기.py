from collections import deque
import sys

n = int(input())
graph = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]

# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y):
    visited[x][y] = True
    size = 1  # 자기 자신 포함

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if not visited[nx][ny] and graph[nx][ny] == 1:
                size += dfs(nx, ny)  # 재귀적으로 사이즈 누적
    return size

# 결과 저장용
sizes = []

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1 and not visited[i][j]:
            sizes.append(dfs(i, j))

print(len(sizes))
for s in sorted(sizes):
    print(s)
