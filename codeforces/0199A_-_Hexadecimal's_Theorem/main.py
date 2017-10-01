from bisect import bisect

f = [0, 1, 1, 2, 3]
i = 5
cur = 3
while cur < int(1e10):
    cur = f[i-1] + f[i-2]
    f.append(cur)
    i += 1

def main(n):
    if n == 0:
        return "0 0 0"
    if n == 1:
        return "0 0 1"
    i = bisect(f, n) - 1
    a = f[i-2]
    b = f[i-2]
    c = f[i-3]
    return "{} {} {}".format(a, b, c)

print(main(int(input())))
