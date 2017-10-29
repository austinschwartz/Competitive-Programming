from math import sqrt

def main():
    (n, k) = map(int, input().split(' '))
    if k > n:
        return -1
    s = set()
    a = []
    b = []
    for i in range(1, int(sqrt(n)) + 1):
        if n % i == 0:
            if i not in s:
                a.append(i)
                s.add(i)
            if n // i not in s:
                b.append(n // i)
                s.add(n // i)
    a = a + b[::-1]
    ret = -1
    try:
        ret = a[k - 1]
    except Exception as e:
        ret = -1
    return ret

print(main())
