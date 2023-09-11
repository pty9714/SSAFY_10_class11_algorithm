def solution(temperature, t1, t2, a, b, onboard):
    answer = 0
    t = temperature
    
    info = [[] for _ in range(t + len(onboard)+10)]
    for i in range(t-len(onboard)+1, t+len(onboard)):
        if i > temperature:
            dp[i].append([i-1, 0])
        elif i >= t1:
            dp[i].append([i-1, a])
        if i < temperature:
            dp[i].append([i+1, 0])
        elif i <= t2:
            dp[i].append([i+1, a])
        if i == temperature:
            dp[i].append([i, 0])
        elif t1 <= i <= t2:
            dp[i].append([i, b])
            
    dp = [[] for _ in range(len(onboard))]
    dp[0] = t
    for i in range(1, len(onboard)):
        for ct in dp[i-1]:
            for nt in info[i]:
                if onboard[i] and t1 <= nt <= t2:
                    dp.append(nt)
                elif not onboard[i]:
                    dp.append(nt)
          
    return answer
