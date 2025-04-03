import sys
input = sys.stdin.readline

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
result = [[0] * N for _ in range(N)]

def dfs(start, visited):
    for i in range(N):
        if graph[start][i] == 1 and not visited[i]:
            visited[i] = True
            dfs(i, visited)

for i in range(N):
    visited = [False] * N
    dfs(i, visited)
    for j in range(N):
        if visited[j]:
            result[i][j] = 1

for row in result:
    print(*row)
