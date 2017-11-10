def main(n, m):
    if n == m:
        return (n - 1, m)
    if n > m:
        temp = n
        n = m
        m = temp
    return (m - 1, n)

print("{} {}".format(*main(*list(map(int, input().split(' '))))))
