N = int(input())
honey = list(map(int, input().split(" ")))


p_sum_front = [0] * N
p_sum_back = [0] * N

p_sum_front[0] = honey[0]
p_sum_back[0] = honey[N-1]

for i in range(1, N):
    p_sum_front[i] = p_sum_front[i - 1] + honey[i]
    p_sum_back[i] = p_sum_back[i-1] + honey[N-i-1]

answer = max(honey[1 : N - 1]) + p_sum_front[N - 1] - honey[0] - honey[N - 1]

for i in range(1, N):
    answer =  max(p_sum_front[N-1] * 2 - p_sum_front[0] - p_sum_front[i] - honey[i], answer)

for i in range(1, N):
    answer = max(answer,  p_sum_back[N-1] * 2 - p_sum_back[0] - p_sum_back[i] - honey[N-i-1])

print(answer)
