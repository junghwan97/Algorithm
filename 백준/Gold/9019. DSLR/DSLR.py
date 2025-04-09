from collections import deque

def bfs(start, target):
    visited = [False] * 10000
    queue = deque()       
    queue.append((start, ""))
    visited[start] = True

    while queue:
        current, operations = queue.popleft()
        # 목표 숫자에 도달하면 경로 반환
        if current == target:
            return operations
        # 각 연산 적용
        for op, next_num in get_next_states(current):
            if not visited[next_num]:
                visited[next_num] = True
                queue.append((next_num, operations + op))

def get_next_states(n):
    result = []

    # D 연산
    d = (n * 2) % 10000
    result.append(('D', d))

    # S 연산
    s = 9999 if n == 0 else n - 1
    result.append(('S', s))

    # L 연산
    l = ((n % 1000) * 10) + (n // 1000)
    result.append(('L', l))

    # R 연산
    r = ((n % 10) * 1000) + (n // 10)
    result.append(('R', r))

    return result

T = int(input())
for _ in range(T):
    A, B = map(int, input().split())
    print(bfs(A, B))
