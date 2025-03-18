import sys
from collections import deque

M, N, H = map(int, sys.stdin.readline().split())
tomato = [[list(map(int, sys.stdin.readline().split())) for _ in range(N)] for _ in range(H)]

# (위, 아래, 앞, 뒤, 왼쪽, 오른쪽)
dz = [1, -1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dx = [0, 0, 0, 0, -1, 1]

# BFS를 위한 큐 초기화 (익은 토마토 위치 저장)
queue = deque()
for h in range(H):
    for n in range(N):
        for m in range(M):
            if tomato[h][n][m] == 1:
                queue.append((h, n, m))

def bfs():
    while queue:
        z, y, x = queue.popleft()
        for i in range(6):
            nz, ny, nx = z + dz[i], y + dy[i], x + dx[i]
            if 0 <= nz < H and 0 <= ny < N and 0 <= nx < M and tomato[nz][ny][nx] == 0:
                tomato[nz][ny][nx] = tomato[z][y][x] + 1
                queue.append((nz, ny, nx))

bfs()

max_days = 0
for layer in tomato:
    for row in layer:
        if 0 in row:
            print(-1)
            sys.exit()
        max_days = max(max_days, max(row))

print(max_days - 1)
