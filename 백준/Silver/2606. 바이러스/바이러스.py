import sys

def dfs(graph, visited, node):
    visited[node] = True
    count = 1  # 현재 노드 감염

    for neighbor in graph[node]:
        if not visited[neighbor]:  # 방문하지 않은 경우
            count += dfs(graph, visited, neighbor)

    return count

# 입력 처리
n = int(sys.stdin.readline())  # 컴퓨터 수
m = int(sys.stdin.readline())  # 연결된 간선 수
graph = {i: [] for i in range(1, n + 1)}  # 그래프 초기화

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)  # 양방향 연결

visited = [False] * (n + 1)

infected_count = dfs(graph, visited, 1) - 1  # 1번 컴퓨터 제외
print(infected_count)