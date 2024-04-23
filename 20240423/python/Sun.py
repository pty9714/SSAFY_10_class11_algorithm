def solution(s):
    answer = []
    l = [-1]*26
    for i in range(len(s)):
        if l[ord(s[i])-ord('a')] == -1 :
            answer.append(-1)
        else:
            answer.append(i-l[ord(s[i])-ord('a')])
        l[ord(s[i])-ord('a')] = i
    return answer

s = "banana"
print(solution(s))