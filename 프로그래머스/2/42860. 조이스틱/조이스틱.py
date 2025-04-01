def solution(name):
    answer = 0
    n = len(name)

    # 1. 알파벳 변경 최소 횟수 계산
    for char in name:
        answer += min(ord(char) - ord('A'), ord('Z') - ord(char) + 1)

    # 2. 좌우 이동 최소 횟수 계산
    move = n - 1  # 최악의 경우: 오른쪽으로 끝까지 가기
    for i in range(n):
        next_idx = i + 1
        # A가 연속되는 구간 찾기
        while next_idx < n and name[next_idx] == 'A':
            next_idx += 1
        # 현재 위치에서 i까지 갔다가, A 뒤로 돌아감
        distance = 2 * i + n - next_idx
        # 또는 뒤로 갔다가 다시 오는 경우도 고려
        alt_distance = i + 2 * (n - next_idx)
        move = min(move, distance, alt_distance)

    return answer + move
