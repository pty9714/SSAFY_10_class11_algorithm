
dx = [1,-1,0,0]
dy = [0,0,1,-1]

n = int(input())
stu = [] 
fri = [[] for _ in range((n**2)+1)]
seat = [[0 for _ in range(n)] for _ in range(n)] 
for i in range(n**2):
    a,b,c,d,e = map(int,input().split())
    stu.append(a)
    fri[a] = [b,c,d,e]

def Seat_student(student):
    cf = 0
    possible_seat = []
    for i in range(n):
        for j in range(n):
            if seat[i][j] == 0:
                check_friend = 0
                check_zero = 0
                for k in range(4):
                    if 0<=i+dx[k]<n and 0<=j+dy[k]<n:
                        if seat[i+dx[k]][j+dy[k]] in fri[student]:
                            check_friend +=1
                        elif seat[i+dx[k]][j+dy[k]] == 0:
                            check_zero +=1

                if cf == check_friend:
                    possible_seat.append([check_zero,i,j,])
                elif cf < check_friend:
                    cf = check_friend
                    possible_seat = [[check_zero,i,j,]]
    
    possible_seat.sort(key = lambda x: (-x[0],x[1],x[2]))
    # print(student, possible_seat)
    seat[possible_seat[0][1]][possible_seat[0][2]] = student

for i in stu:
    Seat_student(i)

# for j in range(n):
#     print(seat[j])

friend_sum = 0
for i in range(n):
    for j in range(n):
        cnt = 0
        for k in range(4):
            if 0<=i+dx[k]<n and 0<=j+dy[k]<n:
                if seat[i+dx[k]][j+dy[k]] in fri[seat[i][j]]:
                    cnt +=1
        
        if cnt>=1:
            friend_sum += 10**(cnt-1)
                

print(friend_sum)

