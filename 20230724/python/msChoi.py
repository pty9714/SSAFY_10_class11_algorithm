T = int(input())
for test_case in range(1, T + 1):
    num = int(input())
    winner = ""
    if num % 2 == 0:
        winner = "Alice"
    else:
        winner = "Bob"
    print("#" + str(test_case) + " " + winner)
