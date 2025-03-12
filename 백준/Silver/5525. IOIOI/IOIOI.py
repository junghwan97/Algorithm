import sys

n = int(sys.stdin.readline().strip())  # Pn의 N 값
m = int(sys.stdin.readline().strip())  # 문자열 S의 길이
s = sys.stdin.readline().strip()  # 문자열 S

count = 0  # Pn 패턴 개수
i = 0  # 문자열 인덱스
pattern_count = 0  # 연속된 IOI 개수

while i < m - 1:
    if s[i:i+3] == "IOI":  # IOI 패턴 찾기
        pattern_count += 1
        if pattern_count >= n:  # Pn 패턴이 만들어졌을 때
            count += 1
        i += 2  # 'IO'가 하나의 단위로 2칸 이동시킴
    else:
        pattern_count = 0  # 연속이 끊기면 초기화
        i += 1  # 1칸 이동

print(count)