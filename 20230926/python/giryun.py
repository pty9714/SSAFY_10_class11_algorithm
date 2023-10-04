import sys

n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())
if m > 0: # 고장난 버튼이 있다면
    broken = set(map(str, sys.stdin.readline().split()))
else: # 엎으면 패스
    broken = {}

ans = abs(n - 100) # 모든 버튼이 고장났을 때
for channel in range(1000001): # 1000000개인 이유: 답이 400000일때 6000000에서 빼는 게 최적값일 경우를 고려
    for c in str(channel): # 채널이 고장난 버튼을 포함하는 경우 패스
        if c in broken:
            break
    else: # 없을 경우
        ans = min(ans, len(str(channel)) + abs(n - channel))

print(ans)
