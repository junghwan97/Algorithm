import sys

def get_receiver_top_orders(n, heights):
    answer = [0] * n  # 결과를 저장할 배열
    stack = []  # 스택: (탑의 높이, 인덱스)를 저장

    for i in range(n):
        while stack and stack[-1][0] < heights[i]:  
            stack.pop()  # 자신보다 작은 탑은 신호를 받을 수 없으므로 제거
        
        # 스택이 비어 있지 않다면, 가장 가까운 큰 탑을 찾음
        if stack:
            answer[i] = stack[-1][1] + 1  # 인덱스는 1부터 시작하므로 +1
        
        # 현재 탑을 스택에 추가
        stack.append((heights[i], i))  

    return answer

# 입력 처리
n = int(sys.stdin.readline().strip())  # 탑 개수 입력
heights = list(map(int, sys.stdin.readline().split()))  # 탑 높이 입력

# 결과 출력
print(" ".join(map(str, get_receiver_top_orders(n, heights))))
