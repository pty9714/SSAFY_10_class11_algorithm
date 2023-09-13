import math
def solution(temperature, t1, t2, a, b, onboard):
    diff = temperature - t2 if temperature > t2 else t1 - temperature
    result = [[ 1000000 for i in range(diff+1) ]+[0]]
    last_passenger_index = 0
    for i in range(1, len(onboard)):
        arr = []
        for j in range(diff+2):
            temp = [result[i-1][j]+b]
            if j == diff + 1:
                temp.append(result[i-1][j])
            if j <= diff:
                temp.append(result[i-1][j+1] + a)
            if j > 0:
                temp.append(result[i-1][j-1])
            min_cost = min(temp)
            if onboard[i] == 1:
                last_passenger_index = i
                if j > 1:
                    min_cost = 100000 
            arr.append(min_cost)
        result.append(arr)
    return min(result[last_passenger_index])