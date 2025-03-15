from collections import deque

def bfs(maze, n, m):
    dx = [1, -1, 0, 0] # 상, 하, 좌, 우 (행 이동)
    dy = [0, 0, 1, -1] # 상, 하, 좌, 우 (열 이동)

    # BFS를 위한 큐
    queue = deque()
    queue.append((0, 0))  # (0,0)에서 시작

    while queue:
        x, y = queue.popleft()

        # 네 방향으로 이동
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            # 범위를 벗어나지 않고, 이동할 수 있는 경우
            if 0 <= nx < n and 0 <= ny < m and maze[nx][ny] == 1:
                queue.append((nx, ny))
                maze[nx][ny] = maze[x][y] + 1  # 거리 갱신

    return maze[n-1][m-1]  # 도착 지점의 값 반환

n, m = map(int, input().split())
maze = [list(map(int, input().strip())) for _ in range(n)]

print(bfs(maze, n, m))