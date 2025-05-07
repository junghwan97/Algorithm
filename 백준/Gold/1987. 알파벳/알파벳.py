import sys
sys.setrecursionlimit(10000)

r, c = map(int, sys.stdin.readline().split())
board = [list(sys.stdin.readline().strip()) for _ in range(r)]
visited = [False] * 26
max_length = 0

def dfs(x, y, length):
    global max_length
    max_length = max(max_length, length)
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < r and 0 <= ny < c:
            idx = ord(board[nx][ny]) - ord('A')
            if not visited[idx]:
                visited[idx] = True
                dfs(nx, ny, length + 1)
                visited[idx] = False

visited[ord(board[0][0]) - ord('A')] = True
dfs(0, 0, 1)
print(max_length)
