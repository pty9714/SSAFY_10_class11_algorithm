# 31120	kb 80 ms

def get_wh_from_bill(bill):
    arr = [100 * 2, 100 * 2 + 9900 * 3, 100 * 2 + 9900 * 3 + 990000 * 5]

    if bill <= arr[0]:
        return bill // 2
    if bill <= arr[1]:
        return 100 + (bill - arr[0]) // 3
    if bill <= arr[2]:
        return 10000 + (bill - arr[1]) // 5

    return 1000000 + (bill - arr[2]) // 7


def get_bill_from_wh(wh):
    arr = [100, 10000, 1000000]

    if wh < arr[0]:
        return wh * 2
    if wh < arr[1]:
        return 100 * 2 + (wh - 100) * 3
    if wh < arr[2]:
        return 100 * 2 + 9900 * 3 + (wh - 10000) * 5

    return 100 * 2 + 9900 * 3 + 990000 * 5 + (wh - 1000000) * 7


def binary_search(start, end):
    total_wh = end  # (상근 + 이웃) 전기사용량

    while True:
        my_wh = (start + end) // 2  # 상근이 전기사용량
        your_wh = total_wh - my_wh  # 이웃 전기사용량

        diff = get_bill_from_wh(your_wh) - get_bill_from_wh(my_wh)

        if diff == B:
            return get_bill_from_wh(my_wh)

        if diff > B:
            start = my_wh + 1
        else:
            end = my_wh - 1


while True:
    A, B = map(int, input().split())

    if A == B == 0:
        break

    # 1. 총 전기 사용량(Wh) 구하기
    wh = get_wh_from_bill(A)

    # 2. 상근이의 전기 사용량 구하기
    print(binary_search(1, wh))
