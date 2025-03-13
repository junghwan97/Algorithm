import sys
input = sys.stdin.read

def blackjack():    
    data = input().split("\n")
    N, M = map(int, data[0].split())  # 카드 개수 N, 목표 숫자 M
    cards = list(map(int, data[1].split()))  # 카드 리스트

    max_sum = 0  # 최대값 저장
    length = len(cards)

    # 3중 반복문을 이용한 모든 경우 탐색 (완전 탐색)
    for i in range(length - 2):
        for j in range(i + 1, length - 1):
            for k in range(j + 1, length):
                card_sum = cards[i] + cards[j] + cards[k]  # 세 카드 합
                if card_sum <= M:  # M을 넘지 않는 경우에만 고려
                    max_sum = max(max_sum, card_sum)

    print(max_sum)

blackjack()