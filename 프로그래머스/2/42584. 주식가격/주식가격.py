from collections import deque

def solution(prices):
    answer = []
    prices = deque(prices)
    
    while prices:
        price_not_fail_period = 0
        current_price = prices.popleft()
        for next_price in prices:
            if current_price > next_price:
                price_not_fail_period += 1
                break
            price_not_fail_period += 1
        answer.append(price_not_fail_period)
    return answer