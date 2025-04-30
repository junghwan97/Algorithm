import sys

arr = sys.stdin.readline().split('-')

sums = []
for part in arr:
    numbers = map(int, part.split('+')) 
    total = sum(numbers)
    sums.append(total)
    
result = sums[0]
for s in sums[1:]:
    result -= s

print(result)
