from collections import deque

n = int(input())
arr = deque()
for i in range(1, n + 1):
    arr.append(i)
while len(arr) > 1:
    arr.popleft()
    arr.append(arr[0])
    arr.popleft()
print(arr[0])