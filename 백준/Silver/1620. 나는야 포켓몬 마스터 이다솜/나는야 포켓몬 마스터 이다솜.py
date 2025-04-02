import sys

n, m = map(int, sys.stdin.readline().split())
name_to_num = {}
num_to_name = {}
for i in range(1, n + 1):
    data = sys.stdin.readline().strip()
    name_to_num[data] = i
    num_to_name[i] = data

for _ in range(m):
    request = sys.stdin.readline().strip()
    if request.isdigit():
        print(num_to_name[int(request)])
    else:
        print(name_to_num[request])