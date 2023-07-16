# def solution(numbers):
#     answer = []
#     for i in range(len(numbers)):
#         for j in range(i+1,len(numbers)):
#             if numbers[i]<numbers[j]:
#                 answer.append(numbers[j])
#                 break
#         else:
#             answer.append(-1)
#     return answer
# 시간초과


def solution(numbers):
    answer = [-1] * (len(numbers))
    stack = []
    for i in range(len(numbers)):
        while stack and numbers[stack[-1]] < numbers[i]:
            answer[stack.pop()] = numbers[i]
        stack.append(i)
    return answer
            