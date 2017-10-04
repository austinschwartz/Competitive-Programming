def c(a):
    return (a * (a - 1)) // 2

def main():
    (n, m) = map(int, input().split(' '))
    if m == 1:
        mi = c(n)
        ma = c(n)
    else:
        mi = (m - (n % m)) * c(n // m)
        mi += ((n % m) * c(n // m + 1))
        ma = c(n - m + 1)

    print('{} {}'.format(mi, ma))


main()

