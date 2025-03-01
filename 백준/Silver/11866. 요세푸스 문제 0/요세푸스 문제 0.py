from collections import deque

N, K = map(int, input().split())

# 1부터 N까지의 숫자를 deque에 저장
queue = deque(range(1, N + 1))

# 제거된 순서를 저장할 리스트
result = []

while queue:
    # K-1번 앞에서 꺼낸 후 뒤로 이동
    queue.rotate(-(K - 1))
    
    # K번째 요소 제거 후 결과 리스트에 추가
    result.append(queue.popleft())

print("<" + ", ".join(map(str, result)) + ">")