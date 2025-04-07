import sys
from collections import deque

n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dx = [-1, 0, 0, 1]  # 위, 왼, 오, 아래
dy = [0, -1, 1, 0]

# 아기 상어 초기 위치와 크기 설정
for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            shark_x, shark_y = i, j
            graph[i][j] = 0  # 초기 위치는 빈칸으로 바꿈

def bfs(x, y, size):
    visited = [[False]*n for _ in range(n)]
    dist = [[0]*n for _ in range(n)]
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    fishes = []

    while q:
        cx, cy = q.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if graph[nx][ny] <= size:  # 지나갈 수 있음
                    visited[nx][ny] = True
                    dist[nx][ny] = dist[cx][cy] + 1
                    q.append((nx, ny))
                    if 0 < graph[nx][ny] < size:
                        fishes.append((dist[nx][ny], nx, ny))

    # 거리, 행, 열 순으로 정렬
    fishes.sort()
    return fishes

time = 0
size = 2
eat = 0

while True:
    fishes = bfs(shark_x, shark_y, size)
    if not fishes:
        break
    dist, nx, ny = fishes[0]
    time += dist
    eat += 1
    graph[nx][ny] = 0
    shark_x, shark_y = nx, ny
    if eat == size:
        size += 1
        eat = 0

print(time)