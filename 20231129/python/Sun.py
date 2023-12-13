d = {}
mod = 1000000007

def fibo(n):
    if n <= 0:
        return 0
    elif n == 1 or n == 2:
        return 1
    elif n in d:
        return d[n]
    else:
        if n % 2 == 1:
            m = (n + 1) // 2
            t1 = fibo(m)
            t2 = fibo(m - 1)
            d[n] = (t1 * t1 + t2 * t2) % mod
            return d[n]
        else:
            m = n // 2
            t1 = fibo(m - 1)
            t2 = fibo(m)
            d[n] = ((2 * t1 + t2) * t2) % mod
            return d[n]


n = int(input())
print(fibo(n))

#메모리 31120kb 시간 44ms