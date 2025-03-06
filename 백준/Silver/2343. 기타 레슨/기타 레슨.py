import sys

# 블루레이 개수를 세는 함수
def count_bluerays(lessons, size):
    count = 1  # 블루레이 개수 (최소 1개 필요)
    total = 0  # 현재 블루레이에 저장된 길이

    for lesson in lessons:
        if total + lesson > size:  # 현재 블루레이 초과 시 새 블루레이 필요
            count += 1
            total = lesson  # 새 블루레이에 강의 추가
        else:
            total += lesson  # 현재 블루레이에 강의 추가

    return count  # 사용된 블루레이 개수 반환

# 이진 탐색 수행
def binary_search(lessons, M):
    left = max(lessons)  # 최소 블루레이 크기 (가장 긴 강의)
    right = sum(lessons)  # 최대 블루레이 크기 (모든 강의 길이 합)

    while left < right:
        mid = (left + right) // 2

        if count_bluerays(lessons, mid) <= M:  # M개 이하 블루레이로 가능
            right = mid  # 더 작은 크기도 가능한지 탐색
        else:
            left = mid + 1  # 현재 크기로는 부족하므로 크기 증가

    return left  # 최소 블루레이 크기 반환

# 입력 처리
N, M = map(int, sys.stdin.readline().split())
lessons = list(map(int, sys.stdin.readline().split()))

# 결과 출력
print(binary_search(lessons, M))
