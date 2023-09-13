def solution(temperature, t1, t2, a, b, onboard):
    k = 1000 * 100
    t1 += 10
    t2 += 10
    temperature += 10
    
    # DP[i][j] : i분에 j 온도를 만들 수 있는 가장 적은 전력
    DP = [[k] * 51 for _ in range(len(onboard))] # j = 0 : -10 // = 50 : 40
    DP[0][temperature] = 0
    
    flag = 1 # 에어컨을 가동했을때 온도가 변하는 방향
    if temperature > t2 :
        flag = -1
    
    for i in range(1, len(onboard)):
        for j in range(51):
            arr = [k]
            if (onboard[i] == 1 and t1 <= j <= t2) or onboard[i] == 0:
                # 1. 에어컨을 키지 않고 실외온도와 달라서 실내온도가 -flag 되는 경우
                if 0 <= j+flag <= 50 :
                    arr.append(DP[i-1][j+flag])
                # 2. 에어컨을 키지 않고 현재온도 j 가 실외온도랑 같아서 변하지 않는 경우
                if j == temperature:
                    arr.append(DP[i-1][j])
                # 3. 에어컨을 키고 현재온도가 변하는 경우
                if 0 <= j-flag <= 50:
                    arr.append(DP[i-1][j-flag] + a)
                # 4. 에어컨을 키고 현재온도가 희망온도라서 온도가 변하지 않는경우
                if t1 <= j <= t2:
                    arr.append(DP[i-1][j] + b)

                DP[i][j] = min(arr)
            
    answer = min(DP[len(onboard)-1])
    return answer

###
테스트 1 〉	통과 (0.19ms, 10.2MB)
테스트 2 〉	통과 (76.23ms, 10.9MB)
테스트 3 〉	통과 (16.38ms, 10.4MB)
테스트 4 〉	통과 (0.06ms, 10.3MB)
테스트 5 〉	통과 (0.21ms, 10.2MB)
테스트 6 〉	통과 (0.22ms, 10.4MB)
테스트 7 〉	통과 (0.21ms, 10.3MB)
테스트 8 〉	통과 (0.28ms, 10.2MB)
테스트 9 〉	통과 (0.33ms, 10.3MB)
테스트 10 〉	통과 (7.41ms, 10.4MB)
테스트 11 〉	통과 (5.77ms, 10.4MB)
테스트 12 〉	통과 (11.45ms, 10.2MB)
테스트 13 〉	통과 (42.64ms, 10.6MB)
테스트 14 〉	통과 (32.74ms, 10.4MB)
테스트 15 〉	통과 (29.65ms, 10.7MB)
테스트 16 〉	통과 (34.62ms, 11MB)
테스트 17 〉	통과 (23.98ms, 10.4MB)
테스트 18 〉	통과 (23.35ms, 10.7MB)
테스트 19 〉	통과 (27.70ms, 10.4MB)
테스트 20 〉	통과 (32.01ms, 10.5MB)
테스트 21 〉	통과 (37.65ms, 11.3MB)
테스트 22 〉	통과 (46.86ms, 10.5MB)
테스트 23 〉	통과 (49.55ms, 10.4MB)
테스트 24 〉	통과 (48.52ms, 12MB)
테스트 25 〉	통과 (44.71ms, 11.9MB)
