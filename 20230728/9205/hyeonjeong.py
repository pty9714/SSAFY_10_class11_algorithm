for _ in range(int(input())):
    n = int(input())
    start_i, start_j = map(int, input().split())
    store = []
    for _ in range(n):
        store.append(list(map(int, input().split())))
    end_i, end_j = map(int, input().split())
    beer = 1000

    store.sort(key=lambda x: abs(abs(x[0]+x[1])-abs((start_i+start_j))))

    while store:
        store_i, store_j = store.pop(0)
        distance = (store_i - start_i) + (store_j - start_j)
        festival = (end_i - start_i) + (end_j - start_j)
        if beer >= festival:
            break
        elif distance <= beer:
            beer = 1000
            start_i = store_i
            start_j = store_j

    if (end_i - start_i) + (end_j - start_j) > beer:
        print("sad")
    else:
        print("happy")
