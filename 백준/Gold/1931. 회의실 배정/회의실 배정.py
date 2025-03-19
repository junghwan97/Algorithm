import sys

n = int(input())
arr = [tuple(map(int, sys.stdin.readline().split())) for _ in range(n)]

sorted_arr = sorted(arr, key=lambda x: (x[1], x[0]))

count = 0
end_time = 0
for start, end in sorted_arr:
    if start >= end_time:
        count += 1
        end_time = end
print(count)