answer = []
def addA(word):
    return word + "A"

def flipAddB(word):
    return word[::-1] + "B"

def simulate(start, target):
    if start == target:
        answer.append(start)
        return
    if len(start) >= len(target):
        return
    # 백트래킹
    simulate(addA(start), target)
    simulate(flipAddB(start), target)

S = input()
T = input()
simulate(S, T)

if answer:
    print(1)
else:
    print(0)

# ---
# 시간초과
