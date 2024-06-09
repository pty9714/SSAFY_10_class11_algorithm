import sys
def add(dic, arr):
    if len(arr) == 0:
        return

    if arr[0] not in dic:
        dic[arr[0]] = {}
    add(dic[arr[0]], arr[1:])
    
def printTree(dic, leng):
    for i in sorted(dic.keys()):
        print("--"*leng+i)
        printTree(dic[i],leng+1)
    
N = int(input())
input = sys.stdin.readline
dict = {} #시작 선언 
tree = []

for _ in range(N):
    #2 B A - 숫자 분리, 2는 무시
    s, *arr = input().split()
    add(dict, arr)
printTree(dict,0)
            