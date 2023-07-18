# target -> start 방향으로 체크
def simulate(start, target):
    while len(target) != len(start):
        if target[-1] == "A":
            target = target[:-1]
        elif target[-1] == "B":
            target = target[:-1][::-1]
    return start, target


S = input()
T = input()

s, t = simulate(S, T)

if s == t:
    print(1)
else:
    print(0)

# ---
# `목표` 문자열에서 `처음` 문자열로 맞추려는 아이디어를 낼 수 있느냐가 포인트였던 것 같다.
