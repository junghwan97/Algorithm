from collections import deque

# DFS 구현 (재귀)
def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=' ')  # 방문한 노드 출력
    for neighbor in graph[v]:  # 인접 노드 탐색
        if not visited[neighbor]:  # 방문하지 않은 경우 탐색
            dfs(graph, neighbor, visited)

# BFS 구현 (큐 사용)
def bfs(graph, start):
    queue = deque([start])
    visited = {start}  # 방문한 노드 저장
    while queue:
        v = queue.popleft()  # 큐에서 노드 꺼내기
        print(v, end=' ')  # 방문한 노드 출력
        for neighbor in graph[v]:
            if neighbor not in visited:  # 방문하지 않은 경우
                queue.append(neighbor)
                visited.add(neighbor)

# 입력 받기
n, m, v = map(int, input().split())  # 정점 수, 간선 수, 시작 정점
graph = {i: [] for i in range(1, n + 1)}

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 인접 리스트 정렬 (작은 노드부터 탐색하기 위해)
for key in graph:
    graph[key].sort()

# DFS 수행
visited = [False] * (n + 1)
dfs(graph, v, visited)
print()

# BFS 수행
bfs(graph, v)
