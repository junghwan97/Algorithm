import sys
sys.setrecursionlimit(10000)  # 최대 재귀 깊이를 10000으로 설정하여 깊은 탐색이 가능하도록 설정

# DFS 함수 정의
def dfs(x, y):
    dx = [0, 0, -1, 1]  # 상하좌우 방향 벡터
    dy = [-1, 1, 0, 0]
    
    # 현재 위치 방문 처리
    visited[y][x] = True
    
    # 상하좌우 탐색
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < M and 0 <= ny < N:  # 범위 확인
            if not visited[ny][nx] and graph[ny][nx] == 1:  # 배추가 있고 방문 전이면 DFS 수행
                dfs(nx, ny)

# 입력 받기
t = int(sys.stdin.readline())
for _ in range(t):
    M, N, K = map(int, sys.stdin.readline().split())
    
    # 배추밭 초기화
    graph = [[0] * M for _ in range(N)]
    visited = [[False] * M for _ in range(N)]
    
    # 배추 위치 입력
    for _ in range(K):
        x, y = map(int, sys.stdin.readline().split())
        graph[y][x] = 1
    
    # 배추 영역 개수 카운트
    count = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1 and not visited[i][j]:
                dfs(j, i)
                count += 1
    
    print(count)