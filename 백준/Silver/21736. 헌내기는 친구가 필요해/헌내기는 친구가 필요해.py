from collections import deque

n, m = map(int, input().split())
campus = [list(input()) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

visited = [[False] * m for _ in range(n)]

x, y = 0, 0

for i in range(n):
    for j in range(m):
        if campus[i][j] == 'I':
            x, y = i, j

count = 0

def bfs(x, y):
    global count
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True

    while queue:
        a, b = queue.popleft()

        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and campus[nx][ny] != 'X':
                    visited[nx][ny] = True
                    if campus[nx][ny] == 'P':
                        count += 1
                    queue.append((nx, ny))

bfs(x, y)

if count > 0:
    print(count)
else :
    print('TT')