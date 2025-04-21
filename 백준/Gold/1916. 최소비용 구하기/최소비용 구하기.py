import heapq
import sys
input = sys.stdin.readline

# 도시 수, 버스 수 입력
n = int(input())
m = int(input())

# 그래프 초기화
graph = [[] for _ in range(n + 1)]

# 버스 정보 입력
for _ in range(m):
    u, v, cost = map(int, input().split())
    graph[u].append((v, cost))  # u에서 v로 가는 비용이 cost

# 시작 도시와 도착 도시
start, end = map(int, input().split())

# 다익스트라 함수
def dijkstra(start):
    INF = int(1e9)
    distance = [INF] * (n + 1)
    distance[start] = 0
    heap = [(0, start)]  # (비용, 도시)

    while heap:
        dist, now = heapq.heappop(heap)

        # 이미 처리된 도시라면 무시
        if distance[now] < dist:
            continue

        for next_node, cost in graph[now]:
            new_cost = dist + cost
            if new_cost < distance[next_node]:
                distance[next_node] = new_cost
                heapq.heappush(heap, (new_cost, next_node))

    return distance

result = dijkstra(start)
print(result[end])
