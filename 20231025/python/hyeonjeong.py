N = int(input())
nums = list(map(int, input().split()))

# 숫자가 하나이거나 2개인데 다르면 A
if N == 1 or (N == 2 and nums[0] != nums[1]):
    print('A')
# 숫자가 2개인데 같으면 다음 숫자도 같음
elif N == 2 and nums[0] == nums[1]:
    print(nums[0])
# 그 외의 경우
else:
    # 0으로 나누기 방지
    if nums[1] == nums[0]:
        a = 1
        b = 0
    else:
        a = (nums[2]-nums[1]) / (nums[1]-nums[0])
        # 정수 아닌 경우 B
        if int(a) != a:
            print('B')
            exit()
        b = nums[1] - nums[0] * a
    # 나머지 숫자도 규칙 적용되는지 확인
    for i, num in enumerate(nums[:-1]):
        if num * a + b != nums[i+1]:
            print('B')
            exit()
    print(int(nums[-1] * a + b))

# 	31120 kb	40 ms
