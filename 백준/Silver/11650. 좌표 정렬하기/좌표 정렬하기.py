import sys

n = int(sys.stdin.readline().strip())  # 입력 개수
points = []  # 빈 리스트 생성

for _ in range(n):  # n번 반복
	  # 입력받아 정수 변환
    x, y = map(int, sys.stdin.readline().split())
    # 변환된 좌표를 튜플로 리스트에 추가
    points.append((x, y))  

points.sort()  # x 기준 정렬, x가 같으면 y 기준 정렬

for x, y in points:
    print(x, y)
