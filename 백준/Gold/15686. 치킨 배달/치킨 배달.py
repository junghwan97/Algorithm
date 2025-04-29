from itertools import combinations

n, m = map(int, input().split())
city = [list(map(int, input().split())) for _ in range(n)]

houses = []
chickens = []

for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            houses.append((i, j))
        elif city[i][j] == 2:
            chickens.append((i, j))

result = float('inf')

for chicken_set in combinations(chickens, m):
    total_distance = 0
    for hx, hy in houses:
        distance = min(abs(hx - cx) + abs(hy - cy) for cx, cy in chicken_set)
        total_distance += distance
    result = min(result, total_distance)

print(result)
