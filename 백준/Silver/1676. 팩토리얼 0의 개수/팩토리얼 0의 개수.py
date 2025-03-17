n = int(input())
result = 1
count = 0
for i in range(n):
    result *= (n - i)
result = str(result)

for i in result[-1:-(len(result)):-1]:
    if '0' == i:
        count += 1
    else:
        break
print(count)
