import sys

n = int(input())
arr = list(map(int, sys.stdin.readline().split(" ")))
x = int(input())

num_set = set()  # 이미 본 숫자를 저장할 집합
count = 0  # 조건을 만족하는 쌍의 개수

for num in arr:
    if x - num in num_set:  # x - num이 이미 존재하면 조건 만족
        count += 1
    num_set.add(num)  # 현재 숫자를 set에 추가

print(count)