from collections import deque

n, m = map(int, input().split())

graph = [[0] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

def bfs(start):
    visited = [False] * (n + 1)
    distance = [0] * (n + 1)  # 거리 배열
    queue = deque([start])
    visited[start] = True

    while queue:
        current = queue.popleft()
        for neighbor in range(1, n + 1):
            if graph[current][neighbor] == 1 and not visited[neighbor]:
                visited[neighbor] = True
                distance[neighbor] = distance[current] + 1
                queue.append(neighbor)

    return sum(distance[1:])

min_total = float('inf')
answer = 0

for person in range(1, n + 1):
    total_distance = bfs(person)
    if total_distance < min_total:
        min_total = total_distance
        answer = person

print(answer)
