def solution(prices):
    answer = [0] * len(prices)  # 결과 리스트 초기화
    stack = []  # 인덱스를 저장할 스택

    for i, price in enumerate(prices):
        while stack and prices[stack[-1]] > price:  # 가격이 떨어지면
            j = stack.pop()
            answer[j] = i - j  # 떨어지기 전까지 유지된 기간 계산
        stack.append(i)

    while stack:  # 끝까지 남아있는 인덱스 처리
        j = stack.pop()
        answer[j] = len(prices) - 1 - j

    return answer
