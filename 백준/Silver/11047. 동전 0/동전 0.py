import sys

n, k = map(int, sys.stdin.readline().split())
coins = []
for _ in range(n):
    coins.append(int(sys.stdin.readline()))

count = 0
for coin in reversed(coins):
    if coin <= k:
        count += k // coin
        k %= coin
print(count)