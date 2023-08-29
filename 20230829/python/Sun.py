N,K = map(int,input().split())
cnt = 0
while str(bin(N)).count('1') > K:
    N +=1
    cnt +=1
print(cnt)


# 메모리 31256kb 시간 4576 ms