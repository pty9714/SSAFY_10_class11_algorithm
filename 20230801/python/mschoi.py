import math

temp, answer = [], []

def simulate(n, k):
    global temp, answer
    comp = math.factorial(n-1)

    if n == 1:
        answer.append(temp.pop())
        return
    
    q = k // comp
    r = k % comp
    k -= (q*comp)
    
    if r > 0:
        q += 1
    item = temp[q-1]
    answer.append(item)
    del temp[q-1]

    simulate(n-1, k)
        

def solution(n, k):
    global answer, temp
    
    temp = [i for i in range(1,n+1)]
    simulate(n,k)

    return answer

---
## 효율성  테스트
## 테스트 2 〉	통과 (0.03ms, 10.3MB)
