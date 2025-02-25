import sys
import math

M, N = map(int, sys.stdin.readline().split())

# 소수 여부 리스트 (True면 소수, False면 소수 아님)
prime = [True] * (N + 1)
prime[0], prime[1] = False, False  # 0과 1은 소수가 아님

# 에라토스테네스의 체 적용
for i in range(2, int(math.sqrt(N)) + 1):
    if prime[i]:  # i가 소수라면
        for j in range(i * i, N + 1, i):  # i의 배수를 False로 변경
            prime[j] = False

# M 이상 N 이하의 소수 출력
for num in range(M, N + 1):
    if prime[num]:
        print(num)
