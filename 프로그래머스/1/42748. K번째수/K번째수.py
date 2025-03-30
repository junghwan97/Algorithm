def solution(array, commands):
    answer = []
    # commands의 0~2 인덱스를 규칙에 맞게 적용할 수 있도록 공통된 양식 구현
    # array의 첫번째 인덱스가 0이 아닌 1로 적용되어 있다.
    # commands의 크기만큼 반복한 후 매 반복문에서 나온 값을 answer에 넣는다.
    
    for i in range(len(commands)):        
            new_arr = array[commands[i][0] - 1:commands[i][1]]
            new_arr = sorted(new_arr)
            answer.append(new_arr[commands[i][2] - 1])
            new_arr = []
    
        
    return answer