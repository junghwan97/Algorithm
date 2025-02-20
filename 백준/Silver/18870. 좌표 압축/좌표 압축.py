import sys

# N값 입력받기
n = int(sys.stdin.readline().strip())

# 좌표 리스트 입력받기
coords = list(map(int, sys.stdin.readline().split()))

# 중복 제거 후 정렬하여 좌표 압축 리스트 생성
sorted_coords = sorted(set(coords))

# 각 좌표에 대한 압축된 값 매핑 (딕셔너리 사용)
index_map = {}
for idx, value in enumerate(sorted_coords):
    index_map[value] = idx  # 해당 숫자의 압축된 값 저장

# 압축된 좌표 리스트 생성
compressed_result = []
for x in coords:
    compressed_result.append(index_map[x])  # 원본 좌표에 해당하는 압축된 값 가져오기

# 압축된 좌표 출력
print(*compressed_result)
