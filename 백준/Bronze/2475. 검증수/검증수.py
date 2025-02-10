numbers = list(map(int, input().split()))
total = 0 
for x in numbers:
    total += x ** 2

print(total % 10) 