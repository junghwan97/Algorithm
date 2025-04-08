from collections import deque

def bfs():
    visited = [False] * 101
    distance = [0] * 101
    q = deque()
    q.append(1)
    visited[1] = True

    while q:
        current = q.popleft()
        for dice in range(1, 7):  # 주사위 1~6
            next_pos = current + dice
            if next_pos > 100:
                continue
            if next_pos in move:  # 사다리 or 뱀
                next_pos = move[next_pos]
            if not visited[next_pos]:
                visited[next_pos] = True
                distance[next_pos] = distance[current] + 1
                q.append(next_pos)
                if next_pos == 100:
                    return distance[100]
    return distance[100]

N, M = map(int, input().split())
move = dict()
for _ in range(N + M):
    start, end = map(int, input().split())
    move[start] = end

print(bfs())
