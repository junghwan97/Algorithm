from collections import deque

def hide_and_seek(N, K):
    MAX = 100001  # 좌표는 0 ~ 100000
    dist = [float('inf')] * MAX  # 거리 배열, 처음엔 무한대
    dist[N] = 0  # 시작 위치는 시간 0

    dq = deque()
    dq.append(N)

    while dq:
        now = dq.popleft()

        if now == K:
            return dist[K]

        # 순간이동
        if 0 <= now * 2 < MAX and dist[now * 2] > dist[now]:
            dist[now * 2] = dist[now]
            dq.appendleft(now * 2)

        # 앞으로 이동
        if 0 <= now + 1 < MAX and dist[now + 1] > dist[now] + 1:
            dist[now + 1] = dist[now] + 1
            dq.append(now + 1)

        # 뒤로 이동
        if 0 <= now - 1 < MAX and dist[now - 1] > dist[now] + 1:
            dist[now - 1] = dist[now] + 1
            dq.append(now - 1)

N, K = map(int, input().split())
print(hide_and_seek(N, K))
