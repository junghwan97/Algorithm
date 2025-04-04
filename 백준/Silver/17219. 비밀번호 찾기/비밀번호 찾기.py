import sys

input = sys.stdin.readline

N, M = map(int, input().split())

passwords = dict()

for _ in range(N):
    site, pw = input().split()
    passwords[site] = pw

for _ in range(M):
    site = input().strip()
    print(passwords[site])